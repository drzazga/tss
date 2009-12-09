/*****************************************************************
 Agent-based Travel Support System
 Copyright (C) 2006 Maciej Gawinecki & Pawel Kaczmarek 

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor,  Boston, MA  
 02110-1301, USA.
 *****************************************************************/
package ibspan.tss.monitor;

import ibspan.tss.core.storage.ModelLoader;
import ibspan.tss.core.storage.ModelLoaderInitException;
import ibspan.tss.domain.ontology.restaurant.Restaurant;
import ibspan.tss.domain.ontology.restaurant.RestaurantFactory;
import ibspan.tss.domain.vocabulary.RestaurantsDBVocabulary;
import ibspan.tss.um.ontology.AgeSet;
import ibspan.tss.um.ontology.Classification;
import ibspan.tss.um.ontology.ContextParameter;
import ibspan.tss.um.ontology.DressSet;
import ibspan.tss.um.ontology.EventSession;
import ibspan.tss.um.ontology.Interval;
import ibspan.tss.um.ontology.Opinion;
import ibspan.tss.um.ontology.OpinionSet;
import ibspan.tss.um.ontology.ProfessionSet;
import ibspan.tss.um.ontology.StatisticEntry;
import ibspan.tss.um.ontology.StereotypeProfile;
import ibspan.tss.um.ontology.StereotypeProfileData;
import ibspan.tss.um.ontology.User;
import ibspan.tss.um.ontology.UserBehaviourContext;
import ibspan.tss.um.ontology.UserModellingFactory;
import ibspan.tss.um.ontology.UserProfile;
import ibspan.tss.um.ontology.UserProfileData;
import ibspan.tss.um.ontology.WealthSet;
import ibspan.tss.um.vocabulary.HistoryDBVocabulary;
import ibspan.tss.um.vocabulary.ProfilesDBVocabulary;
import ibspan.tss.um.vocabulary.StatisticsDBVocabulary;
import ibspan.tss.um.vocabulary.StereotypesDBVocabulary;
import ibspan.tss.um.vocabulary.UsersDBVocabulary;
import jade.util.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.shared.Lock;
import com.ibm.adtech.jastor.JastorException;
import com.ibm.adtech.jastor.Thing;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * This is simple SWT application for retrieving Travel Support system
 * data persisted in the database.
 * 
 * @author <a href="maciej.gawinecki@ibspan.waw.pl">Maciej Gawinecki</a>
 */
public class SystemMonitor {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="59,79"
	private TabFolder tabFolder = null;
	private Menu menuBar = null;
	private Menu submenu = null;
	private Label labelRestaurants = null;
	private Label labelSingleRestaurant = null;
	private Tree treeRestaurants = null;
	private Table tableSingleRestaurant = null;
	private Composite compositeStereotypes = null;
	private Composite compositeHistory = null;
	private Composite compositeStatistics = null;
	private Composite compositeProfiles = null;
	private Composite compositeProfilesLeft = null;
	private Composite compositeProfilesRight = null;
	private Label labelProfiles = null;
	private List listProfiles = null;
	private Label labelData = null;
	private Table tableData = null;
	private Label labelOpinions = null;
	private Tree treeOpinions = null;
	private Composite compositeUsers = null;
	private Label labelUsers = null;
	private Table tableUsers = null;
	private Composite compositeStereotypesLeft = null;
	private Composite compositeStereotypesRight = null;
	private Label labelStereotypes = null;
	private List listStereotypes = null;
	private Label labelStereoOpinions = null;
	private Tree treeStereoOpinions = null;
	private Label labelStereoData = null;
	private Table tableStereoData = null;
	private Combo comboLog = null;
	
	
	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		GridLayout gridLayout3 = new GridLayout();
		gridLayout3.numColumns = 1;
		sShell = new Shell();
		sShell.setText("TSS SystemMonitor");
		createTabFolder();
		sShell.setLayout(gridLayout3);
		createComboLog();
		sShell.setSize(new Point(439, 414));
		menuBar = new Menu(sShell, SWT.BAR);
		MenuItem submenuItem = new MenuItem(menuBar, SWT.CASCADE);
		submenuItem.setText("&File");
		MenuItem submenuItemHelp = new MenuItem(menuBar, SWT.CASCADE);
		submenuItemHelp.setText("&Help");
		submenuHelp = new Menu(submenuItemHelp);
		MenuItem pushAbout = new MenuItem(submenuHelp, SWT.PUSH);
		pushAbout.setText("&About...");
		pushAbout.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				 MessageBox messageBox =  new MessageBox(sShell, SWT.OK);
					 messageBox.setMessage("This is part of Travel Support Project. \n See more at: \n http://sourceforge.net/projects/e-travel.");
					 messageBox.setText("About");
					 messageBox.open();
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		submenuItemHelp.setMenu(submenuHelp);
		submenu = new Menu(submenuItem);
		MenuItem pushExit = new MenuItem(submenu, SWT.PUSH);
		pushExit.setText("E&xit");
		pushExit.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				mRestaurantsDB.close();
				mStereotypesDB.close();
				mHistoryDB.close();
				mStatisticsDB.close();
				mProfilesDB.close();
				mUsersDB.close();
				System.exit(0);
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		MenuItem submenuItemRefresh = new MenuItem(submenu, SWT.CASCADE);
		submenuItemRefresh.setText("Refresh");
		submenuRefresh = new Menu(submenuItemRefresh);
		submenuItemRefresh.setMenu(submenuRefresh);
		MenuItem pushRefreshRestaurants = new MenuItem(submenuRefresh, SWT.PUSH);
		pushRefreshRestaurants.setText("Refresh restaurants");
		MenuItem pushRefreshStereotypes = new MenuItem(submenuRefresh, SWT.PUSH);
		pushRefreshStereotypes.setText("Refresh stereotypes");
		MenuItem pushRefreshHistory = new MenuItem(submenuRefresh, SWT.PUSH);
		pushRefreshHistory.setText("Refresh history");
		pushRefreshHistory
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						try {
							initHistoryData();
						} catch (Exception e1) {
							logger.log(Level.SEVERE, "Problem while initializing data.", e1);
							log("Problem while initializing data.");
						} 
					}
					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		MenuItem pushRefreshStatistics = new MenuItem(submenuRefresh, SWT.PUSH);
		pushRefreshStatistics.setText("Refresh statistics");
		pushRefreshStatistics
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						try {
							initStatisticsData();
						} catch (Exception e1) {
							logger.log(Level.SEVERE, "Problem while initializing data.", e1);
							log("Problem while initializing data.");
						}
					}
					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		MenuItem pushRefreshProfiles = new MenuItem(submenuRefresh, SWT.PUSH);
		pushRefreshProfiles.setText("Refresh profiles");
		pushRefreshProfiles
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						try {
							initProfilesData();
						} catch (Exception e1) {
							logger.log(Level.SEVERE, "Problem while initializing data.", e1);
							log("Problem while initializing data.");
						} 
					}
					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		MenuItem pushRefreshUsers = new MenuItem(submenuRefresh, SWT.PUSH);
		pushRefreshUsers.setText("Refresh users");
		pushRefreshUsers
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						try {
							initUsersData();
						} catch (Exception e1) {
							logger.log(Level.SEVERE, "Problem while initializing data.", e1);
							log("Problem while initializing data.");
						}
					}
					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		pushRefreshStereotypes
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						try {
							initStereotypesData();
						} catch (Exception e1) {
							logger.log(Level.SEVERE, "Problem while initializing data.", e1);
							log("Problem while initializing data.");
						} 
					}
					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		pushRefreshRestaurants
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						try {
							initRestaurantsData();
						} catch (Exception e1) {
							logger.log(Level.SEVERE, "Problem while initializing data.", e1);
							log("Problem while initializing data.");
						} 
					}
					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		MenuItem separatorRefresh1 = new MenuItem(submenuRefresh, SWT.SEPARATOR);
		MenuItem pushRefreshAll = new MenuItem(submenuRefresh, SWT.PUSH);
		pushRefreshAll.setText("Refresh &all");
		pushRefreshAll
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						initData();
					}
					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		submenuItem.setMenu(submenu);
		sShell.setMenuBar(menuBar);
	}

	/**
	 * This method initializes tabFolder	
	 *
	 */
	private void createTabFolder() {
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.verticalAlignment = GridData.FILL;
		gridData1.grabExcessVerticalSpace = true;
		tabFolder = new TabFolder(sShell, SWT.NONE);
		tabFolder.setLayoutData(gridData1);
		createCompositeStereotypes();
		createCompositeHistory();
		createCompositeStatistics();
		createCompositeProfiles();
		createCompositeUsers();
		createSashFormRestaurants();
		TabItem tabItem22 = new TabItem(tabFolder, SWT.NONE);
		tabItem22.setText("Restaurants");
		tabItem22.setControl(sashFormRestaurants);
		TabItem tabItem1 = new TabItem(tabFolder, SWT.NONE);
		tabItem1.setText("Stereotypes");
		tabItem1.setControl(compositeStereotypes);
		TabItem tabItem2 = new TabItem(tabFolder, SWT.NONE);
		tabItem2.setText("History");
		tabItem2.setControl(compositeHistory);
		TabItem tabItem11 = new TabItem(tabFolder, SWT.NONE);
		tabItem11.setText("Statistics");
		tabItem11.setControl(compositeStatistics);
		TabItem tabItem21 = new TabItem(tabFolder, SWT.NONE);
		tabItem21.setText("Profiles");
		tabItem21.setControl(compositeProfiles);
		TabItem tabItem3 = new TabItem(tabFolder, SWT.NONE);
		tabItem3.setText("Users");
		tabItem3.setControl(compositeUsers);
	}

	/**
	 * This method initializes compositeStereotypes	
	 *
	 */
	private void createCompositeStereotypes() {
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 2;
		compositeStereotypes = new Composite(tabFolder, SWT.NONE);
		createCompositeStereotypesLeft();
		compositeStereotypes.setLayout(gridLayout2);
		createCompositeStereotypesRight();
	}

	/**
	 * This method initializes compositeHistory	
	 *
	 */
	private void createCompositeHistory() {
		GridLayout gridLayout5 = new GridLayout();
		gridLayout5.numColumns = 1;
		gridLayout5.makeColumnsEqualWidth = false;
		compositeHistory = new Composite(tabFolder, SWT.NONE);
		compositeHistory.setLayout(gridLayout5);
		createSashFormHistory();
	}

	/**
	 * This method initializes compositeStatistics	
	 *
	 */
	private void createCompositeStatistics() {
		GridData gridData29 = new GridData();
		gridData29.horizontalAlignment = GridData.FILL;
		gridData29.grabExcessHorizontalSpace = true;
		gridData29.grabExcessVerticalSpace = true;
		gridData29.verticalAlignment = GridData.FILL;
		GridData gridData28 = new GridData();
		gridData28.horizontalAlignment = GridData.FILL;
		gridData28.grabExcessHorizontalSpace = true;
		gridData28.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout4 = new GridLayout();
		gridLayout4.numColumns = 1;
		compositeStatistics = new Composite(tabFolder, SWT.NONE);
		compositeStatistics.setLayout(gridLayout4);
		labelStatistics = new Label(compositeStatistics, SWT.NONE);
		labelStatistics.setText("Statistics entries:");
		labelStatistics.setLayoutData(gridData28);
		createCompositeStatisticsFilter();
		tableStatistics = new Table(compositeStatistics, SWT.BORDER);
		tableStatistics.setHeaderVisible(true);
		tableStatistics.setLayoutData(gridData29);
		tableStatistics.setLinesVisible(true);
	}

	/**
	 * This method initializes compositeProfiles	
	 *
	 */
	private void createCompositeProfiles() {
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 2;
		compositeProfiles = new Composite(tabFolder, SWT.NONE);
		createCompositeProfilesLeft();
		compositeProfiles.setLayout(gridLayout1);
		createCompositeProfilesRight();
	}

	/**
	 * This method initializes compositeProfilesLeft	
	 *
	 */
	private void createCompositeProfilesLeft() {
		GridData gridData15 = new GridData();
		gridData15.grabExcessHorizontalSpace = true;
		gridData15.verticalAlignment = GridData.CENTER;
		gridData15.horizontalAlignment = GridData.FILL;
		GridData gridData14 = new GridData();
		gridData14.horizontalAlignment = GridData.FILL;
		gridData14.grabExcessHorizontalSpace = true;
		gridData14.verticalAlignment = GridData.CENTER;
		GridData gridData13 = new GridData();
		gridData13.grabExcessVerticalSpace = true;
		gridData13.horizontalAlignment = GridData.FILL;
		gridData13.verticalAlignment = GridData.FILL;
		gridData13.grabExcessHorizontalSpace = true;
		GridData gridData12 = new GridData();
		gridData12.horizontalAlignment = GridData.FILL;
		gridData12.grabExcessHorizontalSpace = true;
		gridData12.grabExcessVerticalSpace = true;
		gridData12.verticalAlignment = GridData.FILL;
		GridData gridData10 = new GridData();
		gridData10.horizontalAlignment = GridData.FILL;
		gridData10.grabExcessHorizontalSpace = true;
		gridData10.grabExcessVerticalSpace = true;
		gridData10.verticalAlignment = GridData.FILL;
		compositeProfilesLeft = new Composite(compositeProfiles, SWT.NONE);
		compositeProfilesLeft.setLayout(new GridLayout());
		compositeProfilesLeft.setLayoutData(gridData10);
		labelProfiles = new Label(compositeProfilesLeft, SWT.NONE);
		labelProfiles.setText("Profiles in DB");
		labelProfiles.setLayoutData(gridData15);
		listProfiles = new List(compositeProfilesLeft, SWT.BORDER | SWT.V_SCROLL);
		listProfiles.setLayoutData(gridData13);
		labelData = new Label(compositeProfilesLeft, SWT.NONE);
		labelData.setText("Demographic data");
		labelData.setLayoutData(gridData14);
		tableData = new Table(compositeProfilesLeft, SWT.BORDER);
		tableData.setHeaderVisible(true);
		tableData.setLayoutData(gridData12);
		tableData.setLinesVisible(true);
	}

	/**
	 * This method initializes compositeProfilesRight	
	 *
	 */
	private void createCompositeProfilesRight() {
		GridData gridData17 = new GridData();
		gridData17.horizontalAlignment = GridData.FILL;
		gridData17.grabExcessHorizontalSpace = true;
		gridData17.verticalAlignment = GridData.CENTER;
		GridData gridData16 = new GridData();
		gridData16.grabExcessHorizontalSpace = true;
		gridData16.horizontalAlignment = GridData.FILL;
		gridData16.verticalAlignment = GridData.FILL;
		gridData16.grabExcessVerticalSpace = true;
		GridData gridData11 = new GridData();
		gridData11.horizontalAlignment = GridData.FILL;
		gridData11.grabExcessHorizontalSpace = true;
		gridData11.grabExcessVerticalSpace = true;
		gridData11.verticalAlignment = GridData.FILL;
		compositeProfilesRight = new Composite(compositeProfiles, SWT.NONE);
		compositeProfilesRight.setLayout(new GridLayout());
		compositeProfilesRight.setLayoutData(gridData11);
		labelOpinions = new Label(compositeProfilesRight, SWT.NONE);
		labelOpinions.setText("Opinions");
		labelOpinions.setLayoutData(gridData17);
		treeOpinions = new Tree(compositeProfilesRight, SWT.BORDER);
		treeOpinions.setLayoutData(gridData16);
	}

	/**
	 * This method initializes compositeUsers	
	 *
	 */
	private void createCompositeUsers() {
		GridData gridData19 = new GridData();
		gridData19.horizontalAlignment = GridData.FILL;
		gridData19.grabExcessHorizontalSpace = true;
		gridData19.grabExcessVerticalSpace = true;
		gridData19.verticalAlignment = GridData.FILL;
		GridData gridData18 = new GridData();
		gridData18.horizontalAlignment = GridData.FILL;
		gridData18.grabExcessHorizontalSpace = true;
		gridData18.verticalAlignment = GridData.CENTER;
		compositeUsers = new Composite(tabFolder, SWT.NONE);
		compositeUsers.setLayout(new GridLayout());
		labelUsers = new Label(compositeUsers, SWT.NONE);
		labelUsers.setText("Users in DB");
		labelUsers.setLayoutData(gridData18);
		tableUsers = new Table(compositeUsers, SWT.BORDER);
		tableUsers.setHeaderVisible(true);
		tableUsers.setLayoutData(gridData19);
		tableUsers.setLinesVisible(true);
	}

	/**
	 * This method initializes compositeStereotypesLeft	
	 *
	 */
	private void createCompositeStereotypesLeft() {
		GridData gridData25 = new GridData();
		gridData25.grabExcessHorizontalSpace = true;
		gridData25.verticalAlignment = GridData.CENTER;
		gridData25.horizontalAlignment = GridData.FILL;
		GridData gridData24 = new GridData();
		gridData24.grabExcessHorizontalSpace = true;
		gridData24.verticalAlignment = GridData.CENTER;
		gridData24.horizontalAlignment = GridData.FILL;
		GridData gridData23 = new GridData();
		gridData23.grabExcessHorizontalSpace = true;
		gridData23.verticalAlignment = GridData.FILL;
		gridData23.grabExcessVerticalSpace = true;
		gridData23.horizontalAlignment = GridData.FILL;
		GridData gridData22 = new GridData();
		gridData22.grabExcessHorizontalSpace = true;
		gridData22.verticalAlignment = GridData.FILL;
		gridData22.grabExcessVerticalSpace = true;
		gridData22.horizontalAlignment = GridData.FILL;
		GridData gridData21 = new GridData();
		gridData21.horizontalAlignment = GridData.FILL;
		gridData21.grabExcessHorizontalSpace = true;
		gridData21.grabExcessVerticalSpace = true;
		gridData21.verticalAlignment = GridData.FILL;
		compositeStereotypesLeft = new Composite(compositeStereotypes, SWT.NONE);
		compositeStereotypesLeft.setLayout(new GridLayout());
		compositeStereotypesLeft.setLayoutData(gridData21);
		labelStereotypes = new Label(compositeStereotypesLeft, SWT.NONE);
		labelStereotypes.setText("Stereotypes in DB");
		labelStereotypes.setLayoutData(gridData25);
		listStereotypes = new List(compositeStereotypesLeft, SWT.BORDER);
		listStereotypes.setLayoutData(gridData22);
		labelStereoData = new Label(compositeStereotypesLeft, SWT.NONE);
		labelStereoData.setText("Demographic data");
		labelStereoData.setLayoutData(gridData24);
		tableStereoData = new Table(compositeStereotypesLeft, SWT.BORDER);
		tableStereoData.setHeaderVisible(true);
		tableStereoData.setLayoutData(gridData23);
		tableStereoData.setLinesVisible(true);
	}

	/**
	 * This method initializes compositeStereotypesRight	
	 *
	 */
	private void createCompositeStereotypesRight() {
		GridData gridData27 = new GridData();
		gridData27.grabExcessHorizontalSpace = true;
		gridData27.verticalAlignment = GridData.CENTER;
		gridData27.horizontalAlignment = GridData.FILL;
		GridData gridData26 = new GridData();
		gridData26.grabExcessVerticalSpace = true;
		gridData26.horizontalAlignment = GridData.FILL;
		gridData26.verticalAlignment = GridData.FILL;
		gridData26.grabExcessHorizontalSpace = true;
		GridData gridData20 = new GridData();
		gridData20.horizontalAlignment = GridData.FILL;
		gridData20.grabExcessHorizontalSpace = true;
		gridData20.grabExcessVerticalSpace = true;
		gridData20.verticalAlignment = GridData.FILL;
		compositeStereotypesRight = new Composite(compositeStereotypes, SWT.NONE);
		compositeStereotypesRight.setLayout(new GridLayout());
		compositeStereotypesRight.setLayoutData(gridData20);
		labelStereoOpinions = new Label(compositeStereotypesRight, SWT.NONE);
		labelStereoOpinions.setText("Opinions of stereotype");
		labelStereoOpinions.setLayoutData(gridData27);
		treeStereoOpinions = new Tree(compositeStereotypesRight, SWT.BORDER);
		treeStereoOpinions.setLayoutData(gridData26);
	}

	/**
	 * This method initializes comboLog	
	 *
	 */
	private void createComboLog() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		comboLog = new Combo(sShell, SWT.V_SCROLL | SWT.READ_ONLY);
		comboLog.setBackground(new Color(Display.getCurrent(), 255, 255, 212));
		comboLog.setLayoutData(gridData);
	}
	
	

	/*
	 * ---------------------------------------------------------------------------------------
	 */

	private static Logger logger = Logger.getMyLogger(SystemMonitor.class
			.getName());  //  @jve:decl-index=0:

	private OntModel mRestaurantsDB; //  @jve:decl-index=0:
	private OntModel mStereotypesDB;
	private OntModel mProfilesDB;
	private OntModel mUsersDB;  //  @jve:decl-index=0:
	private OntModel mHistoryDB;
	private OntModel mStatisticsDB;
	private Label labelStatistics = null;
	private Table tableStatistics = null;
	private Menu submenuRefresh = null;
	private Menu submenuHelp = null;
	private Composite compositeEvents = null;
	private Composite compositeSessions = null;
	private Label labelSessions = null;
	private Table tableSessions = null;
	private Label labelEvents = null;
	private Table tableEvents = null;
	private Label labelEventContext = null;
	private Table tableEventContext = null;

	private void initLayout() {
		// Init restaurants layout
		{
			treeRestaurants.setHeaderVisible(true);
			TreeColumn c = new TreeColumn(treeRestaurants, SWT.LEFT);
			c.setWidth(150);
			c.setText("place");
	
			c = new TreeColumn(treeRestaurants, SWT.RIGHT);
			c.setWidth(200);
			c.setText("uri");
	
			TableColumn tc = new TableColumn(tableSingleRestaurant, SWT.NONE);
			tc.setText("Property");
			tc = new TableColumn(tableSingleRestaurant, SWT.NONE);
			tc.setText("Value");
			
			final TableColumn[] columns = tableSingleRestaurant.getColumns();
			for (int i = 0; i < columns.length; i++)
				columns[i].addListener(SWT.Selection, new ColumnListener(tableSingleRestaurant,i));
	
			// add listener
			treeRestaurants.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					String uri = (String) ((TreeItem) event.item).getData();
					if (uri != null)
						showRestaurant(uri);
				}
			});
		}
		
		// Init stereotypes layout
		{
			tableStereoData.setHeaderVisible(true);
			TableColumn c = new TableColumn(tableStereoData, SWT.LEFT);
			c.setWidth(150);
			c.setText("property");
	
			c = new TableColumn(tableStereoData, SWT.RIGHT);
			c.setWidth(200);
			c.setText("possible values");
	
			TableColumn[] columns = tableStereoData.getColumns();
			for (int i = 0; i < columns.length; i++)
				columns[i].addListener(SWT.Selection, new ColumnListener(tableStereoData,i));
			
			treeStereoOpinions.setHeaderVisible(true);
			TreeColumn tc = new TreeColumn(treeStereoOpinions, SWT.LEFT);
			tc.setWidth(150);
	
			tc = new TreeColumn(treeStereoOpinions, SWT.RIGHT);
			tc.setWidth(200);
			
			// add listener
			listStereotypes.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					String val = listStereotypes.getSelection()[0];
					String uri = (String) listStereotypes.getData(val);
					if (uri != null) {
						showStereotypeProfile(uri);
					}
				}
			});
		}
		
		// Init profile layout 
		{
			tableData.setHeaderVisible(true);
			TableColumn c = new TableColumn(tableData, SWT.LEFT);
			c.setWidth(150);
			c.setText("property");

			c = new TableColumn(tableData, SWT.RIGHT);
			c.setWidth(200);
			c.setText("value");

			TableColumn[] columns = tableData.getColumns();
			for (int i = 0; i < columns.length; i++)
				columns[i].addListener(SWT.Selection, new ColumnListener(tableData,i));
			
			treeOpinions.setHeaderVisible(true);
			TreeColumn tc = new TreeColumn(treeOpinions, SWT.LEFT);
			tc.setWidth(150);

			tc = new TreeColumn(treeOpinions, SWT.RIGHT);
			tc.setWidth(200);
			
			// add listener
			listProfiles.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					String val = listProfiles.getSelection()[0];
					Resource r = (Resource) listProfiles.getData(val);
					if (r != null) {
						showProfile(r);
					}
					
				}
			});

		}
		
		// Init Users layout
		{
			tableUsers.setHeaderVisible(true);
			TableColumn c;
			
			c = new TableColumn(tableUsers, SWT.LEFT);
			c.setWidth(150);
			c.setText("id");
			
			c = new TableColumn(tableUsers, SWT.LEFT);
			c.setWidth(150);
			c.setText("name");

			c = new TableColumn(tableUsers, SWT.RIGHT);
			c.setWidth(200);
			c.setText("login");
			
			c = new TableColumn(tableUsers, SWT.RIGHT);
			c.setWidth(200);
			c.setText("password");
			
			TableColumn[] columns = tableUsers.getColumns();
			for (int i = 0; i < columns.length; i++)
				columns[i].addListener(SWT.Selection, new ColumnListener(tableUsers,i));
		}
		
		// Init statistics layout
		{
			tableStatistics.setHeaderVisible(true);
			TableColumn c;
			
			c = new TableColumn(tableStatistics, SWT.LEFT);
			c.setText("*");
			
			c = new TableColumn(tableStatistics, SWT.LEFT);
			c.setWidth(150);
			c.setText("user id");
			
		    
			
			c = new TableColumn(tableStatistics, SWT.LEFT);
			c.setWidth(150);
			c.setText("behaviour");

			c = new TableColumn(tableStatistics, SWT.RIGHT);
			c.setWidth(200);
			c.setText("concept");
			
			c = new TableColumn(tableStatistics, SWT.RIGHT);
			c.setWidth(200);
			c.setText("count");
			
			TableColumn[] columns = tableStatistics.getColumns();
			for (int i = 0; i < columns.length; i++)
				columns[i].addListener(SWT.Selection, new ColumnListener(tableStatistics,i));
			

			
			
		}
		
		// Init history layout 
		{
			tableSessions.setHeaderVisible(true);
			TableColumn c;
			
			c = new TableColumn(tableSessions, SWT.LEFT);
			c.setWidth(200);
			c.setText("session id");
			
			c = new TableColumn(tableSessions, SWT.LEFT);
			c.setWidth(100);
			c.setText("started");

			c = new TableColumn(tableSessions, SWT.LEFT);
			c.setWidth(100);
			c.setText("user id");
			
			TableColumn[] columns = tableSessions.getColumns();
			for (int i = 0; i < columns.length; i++)
				columns[i].addListener(SWT.Selection, new ColumnListener(tableSessions,i));

			tableEvents.setHeaderVisible(true);
			
			c = new TableColumn(tableEvents, SWT.LEFT);
			c.setWidth(100);
			c.setText("event id");
			
			c = new TableColumn(tableEvents, SWT.LEFT);
			c.setWidth(100);
			c.setText("when");

			c = new TableColumn(tableEvents, SWT.LEFT);
			c.setWidth(50);
			c.setText("user id");

			c = new TableColumn(tableEvents, SWT.LEFT);
			c.setWidth(150);
			c.setText("behaviour");
			
			columns = tableEvents.getColumns();
			for (int i = 0; i < columns.length; i++)
				columns[i].addListener(SWT.Selection, new ColumnListener(tableEvents,i));
			
			tableEventContext.setHeaderVisible(true);
			
			c = new TableColumn(tableEventContext, SWT.LEFT);
			c.setWidth(150);
			c.setText("parameter");
			
			c = new TableColumn(tableEventContext, SWT.LEFT);
			c.setWidth(150);
			c.setText("value");
			
			columns = tableEventContext.getColumns();
			for (int i = 0; i < columns.length; i++)
				columns[i].addListener(SWT.Selection, new ColumnListener(tableEventContext,i));
			
			// Add session listener
			tableSessions.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					TableItem item = tableSessions.getSelection()[0];
					// Use r for identificatio, since session can be
					// anonymous resource (without URI)
					Resource r= (Resource) item.getData();
					if (r != null) {
						showSessionEvents(r);
					}
				}
			});
						
			// Add event listener
			tableEvents.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					TableItem item = tableEvents.getSelection()[0];
					// Use r for identificatio, since event can be
					// anonymous resource (without URI)
					Resource r= (Resource) item.getData();
					if (r != null) {
						showEventContext(r);
					}
				}
			});
		}
	}
	
	private class ColumnListener implements Listener {
		private int index;
		private Table table;

		
		public ColumnListener(Table table, int i) { index = i; this.table = table; }

		public void handleEvent(Event e) {
			sort(table, index);
		}
	}
	
	private void showSessionEvents(Resource r) {
		try {
			EventSession s = UserModellingFactory.getEventSession(r, mHistoryDB);
			
			tableEvents.removeAll();
			tableEventContext.removeAll();
			for(Iterator<ibspan.tss.um.ontology.Event> it = s.getHasEvent(); it.hasNext();) {
				ibspan.tss.um.ontology.Event e = it.next();
				
				TableItem item;
				
				item = new TableItem(tableEvents, SWT.None);
				item.setData(e.resource());
				item.setText(0, ""+e.getHasEventID());
				
				
				
				item.setText(1, ""+formatDate(e.getWhen()));
				item.setText(2, ""+e.getHasUserID());
				item.setText(3, ""+e.getHasExtendedUserBehaviour()
						.getHasUserBehaviour().resource().getLocalName());
			}
		} catch (JastorException e) {
			logger.severe("Problem with showing session data: " + e);
		}
		
		TableColumn[] columns = tableEvents.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();
	}
	
	
	private SimpleDateFormat format = new SimpleDateFormat();
	private String formatDate(XSDDateTime in) {
		return format.format(in.asCalendar().getTime());
	}
	
	private void showEventContext(Resource r) {
		try {
			ibspan.tss.um.ontology.Event e = UserModellingFactory.getEvent(r, mHistoryDB);
			UserBehaviourContext c = e.getHasExtendedUserBehaviour().getHasContext();
			tableEventContext.removeAll();
			for(Iterator<ContextParameter> it = c.getHasParameter(); it.hasNext();) {
				ContextParameter cp = it.next();
				
				TableItem item;
				
				item = new TableItem(tableEventContext, SWT.None);
				item.setData(e.resource());
				item.setText(0, ""+cp.getHasName());
				item.setText(1, ""+cp.getHasValue());
			}
		} catch (JastorException e) {
			logger.severe("Problem with showing session data: " + e);
		}
		
		TableColumn[] columns = tableEventContext.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();
	}
	
	private void initData() {
		
		try {
			initRestaurantsData();
			initStereotypesData();
			initHistoryData();
			initStatisticsData();
			initProfilesData();
			initUsersData();			
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Problem while initializing data.", e);
			log("Problem while initializing data.");
		} 
	}

	private void initRestaurantsData() throws ModelLoaderInitException {
		log("Loading restaurants from DB...");
		mRestaurantsDB = ModelLoader.loadDBModel(RestaurantsDBVocabulary.NS);

		
		
		Category world = new Category("World", null);
		

		
		Category tmp;
		mRestaurantsDB.enterCriticalSection(Lock.READ);
		try {
			for (Iterator<Restaurant> it = RestaurantFactory.getAllRestaurant(
					mRestaurantsDB).iterator(); it.hasNext();) {
				Restaurant r = it.next();

				Category country = world.getSubCategory(r.getCountry());
				if (country == null)
					country = new Category(r.getCountry(), world);

				Category state = country.getSubCategory(r.getState());
				if (state == null)
					state = new Category(r.getState(), country);

				Category city = state.getSubCategory(r.getCity());
				if (city == null)
					city = new Category(r.getCity(), state);

				tmp = new Category(r.getTitle(), city);
				tmp.setData(r.resource().getLocalName());

			}
		} catch (JastorException e) {
			throw new RuntimeException("Exception while retrieving restaurants from db: ", e);
		} finally {
			mRestaurantsDB.leaveCriticalSection();
		}

		treeRestaurants.removeAll();
		addCategory(treeRestaurants, null, world);
		
		TreeColumn[] columns = treeRestaurants.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();
		
		
		
		log("Done.");

	}

	private void showRestaurant(String uri) {

		tableSingleRestaurant.removeAll();
		mRestaurantsDB.enterCriticalSection(Lock.READ);
		try {
			Restaurant r = RestaurantFactory.getRestaurant(
					RestaurantsDBVocabulary.NS + uri, mRestaurantsDB);
			for (StmtIterator it = r.resource().listProperties(); it.hasNext();) {
				Statement s = it.nextStatement();
				String p = s.getPredicate().getLocalName();
				RDFNode onode = s.getObject();
				String o = onode instanceof Literal ? ((Literal) onode)
						.getString() : ((Resource) onode).getLocalName();
				addProperty(tableSingleRestaurant, p, o);
			}
			
			TableColumn[] columns = tableSingleRestaurant.getColumns();
			for (int i = 0; i < columns.length; i++)
				columns[i].pack();

		} catch (JastorException e) {
			logger.severe("Problem with showing restaurant: " + e);
		} finally {
			mRestaurantsDB.leaveCriticalSection();
		}
		
		TableColumn[] columns = tableSingleRestaurant.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();

	}

	private void addProperty(Table table, String property, String value) {
		TableItem ti = new TableItem(table, SWT.NONE);
		ti.setText(0, property);
		ti.setText(1, value);
	}

	private void initStereotypesData() throws ModelLoaderInitException {
		log("Loading stereotypes from DB...");
		mStereotypesDB = ModelLoader.loadDBModel(StereotypesDBVocabulary.NS);

		listStereotypes.removeAll();
		tableStereoData.removeAll();
		treeStereoOpinions.removeAll();

		mStereotypesDB.enterCriticalSection(Lock.READ);
		try {
			for (Iterator<StereotypeProfile> it = UserModellingFactory
					.getAllStereotypeProfile(mStereotypesDB).iterator(); it
					.hasNext();) {
				StereotypeProfile sp = it.next();
				String val = sp.resource().getLocalName();
				val += " (" + sp.getHasStereotypeID() + ")";
				listStereotypes.add(val);
				listStereotypes.setData(val, sp.resource().getURI());

			}
		} catch (JastorException e) {
			throw new RuntimeException("Problem while retrieving stereotype data: ", e);
		} finally {
			mStereotypesDB.leaveCriticalSection();
		}
		


		log("Done.");
	}
	
	private void initProfilesData() throws ModelLoaderInitException {
		log("Loading profiles from DB...");
		mProfilesDB = ModelLoader.loadDBModel(ProfilesDBVocabulary.NS);

		listProfiles.removeAll();
		tableData.removeAll();
		treeOpinions.removeAll();
		
		mProfilesDB.enterCriticalSection(Lock.READ);
		try {
			for (Iterator<UserProfile> it = UserModellingFactory
					.getAllUserProfile(mProfilesDB).iterator(); it
					.hasNext();) {
				UserProfile p = it.next();
				String val = " (" + p.getHasUserID() + ")";
				listProfiles.add(val);
				listProfiles.setData(val, p.resource());

			}
		} catch (JastorException e) {
			throw new RuntimeException("Problem while retrieving type data: ", e);
		} finally {
			mProfilesDB.leaveCriticalSection();
		}

		log("Done.");
	}

	private void initUsersData() throws ModelLoaderInitException {
		log("Loading users from DB...");
		mUsersDB = ModelLoader.loadDBModel(UsersDBVocabulary.NS);
		tableUsers.removeAll();
			
		mUsersDB.enterCriticalSection(Lock.READ);
		try {
			for (Iterator<User> it = UserModellingFactory
					.getAllUser(mUsersDB).iterator(); it
					.hasNext();) {
				User u = it.next();
				// Chech whether it has anonymous resource
				// or it is LastUser instance, which should not be provided to the user
				if (! u.resource().isURIResource()  || ! u.resource().getLocalName().equals(User.LastUser.getLocalName())) {
					TableItem item = new TableItem(tableUsers, SWT.None);
					item.setText(0, ""+u.getHasUserID());
					item.setText(1, u.getHasName());
					item.setText(2, u.getHasLogin());
					item.setText(3, u.getHasPassword());
				}
			}
		} catch (JastorException e) {
			throw new RuntimeException("Problem while retrieving type data: ", e);
		} finally {
			mUsersDB.leaveCriticalSection();
		}
		
		TableColumn[] columns = tableUsers.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();

		log("Done.");
	}
	
	private void initStatisticsData() throws ModelLoaderInitException {
		log("Loading statistics from DB...");
		mStatisticsDB = ModelLoader.loadDBModel(StatisticsDBVocabulary.NS);
		tableStatistics.removeAll();
				
		mStatisticsDB.enterCriticalSection(Lock.READ);
		cComboUsers.removeAll();
		cComboBehaviours.removeAll();
		cComboConcepts.removeAll();
		
		Set<String> behaviours = new HashSet<String>();
		Set<String> concepts = new HashSet<String>();
		Set<String> users = new HashSet<String>();
		
		try {
			for (Iterator<StatisticEntry> it = UserModellingFactory
					.getAllStatisticEntry(mStatisticsDB).iterator(); it
					.hasNext();) {
				StatisticEntry se = it.next();
				TableItem item = new TableItem(tableStatistics, SWT.None);
			
				String user = "" + (se.getHasUserID() != null ? se.getHasUserID() : "_");
				users.add(user);				
				item.setText(1, ""+user);

				String behaviour = (se.getHasUserBehaviour() != null ? se.getHasUserBehaviour().resource().getLocalName() : "_");
				behaviours.add(behaviour);
				item.setText(2, behaviour);
				
				String concept = (se.getHasConceptURI() != null ? se.getHasConceptURI() :"_");
				concepts.add(concept);
				item.setText(3, concept);
				
				item.setText(4, "" + se.getHasCount());
	
			
			}
		} catch (JastorException e) {
			throw new RuntimeException("Problem while retrieving type data: ", e);
		} finally {
			mStatisticsDB.leaveCriticalSection();
		}
		

		TableColumn[] columns = tableStatistics.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();
		
		
	
		putSorted(cComboUsers, users);
		putSorted(cComboBehaviours, behaviours);
		putSorted(cComboConcepts, concepts);
		
		if (cComboUsers.getItemCount() != 0)
			cComboUsers.select(0);
		if (cComboBehaviours.getItemCount() != 0)
			cComboBehaviours.select(0);
		if (cComboConcepts.getItemCount() != 0)
			cComboConcepts.select(0);
		
		filterStatistics();
	
		log("Done.");
	}
	
	private void filterStatistics() {
		if (cComboUsers.getItemCount() == 0)
			return;
		
		String userMask =  cComboUsers.getItem(cComboUsers.getSelectionIndex());
		String behaviourMask = cComboBehaviours.getItem(cComboBehaviours.getSelectionIndex());
		String conceptMask =  cComboConcepts.getItem(cComboConcepts.getSelectionIndex());

		TableItem[] items = tableStatistics.getItems();
		for(int i = 0; i < items.length; i++) {
			String user = items[i].getText(1);
			String behaviour = items[i].getText(2);
			String concept = items[i].getText(3);
			boolean check = (matchesMask(user,userMask) && matchesMask(behaviour, behaviourMask) && matchesMask(concept, conceptMask));
			items[i].setText(check ? "*" : " ");	
		}
		sort(tableStatistics, 0);
	}
	
	private boolean matchesMask(String s, String mask) {
		return mask.equals("_") || s.equals("_") |mask.equals(s);
	}
	
	private void putSorted(CCombo combo, Set set) {
		java.util.List list = new ArrayList();
		for(Iterator<String> it = set.iterator(); it.hasNext();) 
			list.add(it.next());
		Collections.sort(list);
		for(Iterator<String> it = list.iterator(); it.hasNext();) 
			combo.add(it.next());
	}
	
	private void initHistoryData() throws ModelLoaderInitException {
		log("Loading history from DB...");
		mHistoryDB = ModelLoader.loadDBModel(HistoryDBVocabulary.NS);
		tableSessions.removeAll();
		tableEvents.removeAll();
		tableEventContext.removeAll();
				
	
		
		mHistoryDB.enterCriticalSection(Lock.READ);
		try {
			for (Iterator<EventSession> it = UserModellingFactory
					.getAllEventSession(mHistoryDB).iterator(); it
					.hasNext();) {
				EventSession s = it.next();
				TableItem item = new TableItem(tableSessions, SWT.None);
				item.setData(s.resource());
				item.setText(0, s.getHasSessionID());
				item.setText(1, ""+formatDate(s.getStartedAt()));
				item.setText(2, ""+s.getHasUserID());
			}
		} catch (JastorException e) {
			throw new RuntimeException("Problem while retrieving type data: ", e);
		} finally {
			mHistoryDB.leaveCriticalSection();
		}
		
		final TableColumn[] columns = tableSessions.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();
		
		log("Done.");
	}
	
	private void showStereotypeProfile(String uri) {

		try {
			StereotypeProfile sp;
			sp = UserModellingFactory.getStereotypeProfile(uri, mStereotypesDB);
			showStereotypeOpinions(sp.getHasOpinions());
			 showStereotypeData(sp.getHasStereotypeData());
		} catch (JastorException e) {
			logger.severe("Problem with showing stereotype profile: " + e);
		}

	}
	
	private void showProfile(Resource r) {

		try {
			UserProfile p;
			p = UserModellingFactory.getUserProfile(r, mProfilesDB);
			showProfileOpinions(p.getHasOpinions());
			showProfileData(p.getHasUserProfileData());
		} catch (JastorException e) {
			logger.severe("Problem with showing stereotype profile: " + e);
		}

	}

	private void showStereotypeData(StereotypeProfileData data) {
		try {
			// FIXME: this method only workaround, since there is JASTOR bug
			// which causes NullPointerException when calling "hasContain" property
			
			tableStereoData.removeAll();

			String val;
			TableItem item;
			Thing set;
			
			set = data.getHasAgeSet();
			if (set != null) {
				Resource ager = set.resource(); 
				double l = ager.getProperty(AgeSet.hasLeftBoundProperty).getProperty(Interval.mapsLinearValueProperty).getDouble();
				double r = ager.getProperty(AgeSet.hasRightBoundProperty).getProperty(Interval.mapsLinearValueProperty).getDouble();
				val = l + "-" + r;
				item = new TableItem(tableStereoData, SWT.None);
				item.setText(0, "age: ");
				item.setText(1, val);
			}
			
			TableColumn[] columns = tableStereoData.getColumns();
			for (int i = 0; i < columns.length; i++)
				columns[i].pack();
			
			
			set = data.getHasWealthSet();
			if (set != null) {
				val = "";
				for (StmtIterator it = set
						.resource().listProperties(WealthSet.containsProperty); it.hasNext();) {
					val += it.nextStatement().getResource().getLocalName() + " | ";
				}
				item = new TableItem(tableStereoData, SWT.None);
				item.setText(0, "wealth: ");
				item.setText(1, val);		
			}
				
			
			set = data.getHasDressSet();
			if (set != null) {
				val = "";
				for (StmtIterator it = set.resource().listProperties(DressSet.containsProperty); it.hasNext();) {
					val += it.nextStatement().getResource().getLocalName() + " | ";
				}
				item = new TableItem(tableStereoData, SWT.None);
				item.setText(0, "dress: ");
				item.setText(1, val);	
			}

			set = data.getHasProfessionSet();
			if (set != null) {
				val = "";
				for (StmtIterator it = set
						.resource().listProperties(ProfessionSet.containsProperty); it.hasNext();) {
					val += it.nextStatement().getResource().getLocalName() + " | ";
				}
				item = new TableItem(tableStereoData, SWT.None);
				item.setText(0, "profession: ");
				item.setText(1, val);
			}
		} catch (JastorException e) {
			logger.severe("Problem with showing stereotype data: " + e);
		}

		TableColumn[] columns = tableStereoData.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();
	}
	
	private void showProfileData(UserProfileData data) {
		try {
			tableData.removeAll();
			
			TableItem item;
			
			item = new TableItem(tableData, SWT.None);
			item.setText(0, "wealth: ");
			item.setText(1, data.getHasWealth().resource().getLocalName());

			item = new TableItem(tableData, SWT.None);
			item.setText(0, "dress: ");
			item.setText(1, data.getHasDress().resource().getLocalName());
			
			item = new TableItem(tableData, SWT.None);
			item.setText(0, "profession: ");
			item.setText(1, data.getHasProfession().resource().getLocalName());
			
			item = new TableItem(tableData, SWT.None);
			item.setText(0, "age: ");
			item.setText(1, ""+data.getHasAge().getMapsLinearValue());
		} catch (JastorException e) {
			logger.severe("Problem with showing profile data: " + e);
		}

		
		TableColumn[] columns = tableData.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();
	}


	private void showStereotypeOpinions(OpinionSet opinions) {
		treeStereoOpinions.removeAll();
		try {
			TreeItem item = new TreeItem(treeStereoOpinions, SWT.NONE);
			item.setText("Opinions");
			for (Iterator<Opinion> it = opinions.getContainsOpinion(); it
					.hasNext();) {
				addStereotypeOpinion(it.next(), item);
			}
		} catch (JastorException e) {
			logger.severe("Problem with showing stereotype profile: " + e);
		}
		
		expandTree(treeStereoOpinions);
		
		TreeColumn[] columns =treeStereoOpinions.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();

		
	}
	
	private void showProfileOpinions(OpinionSet opinions) {
		treeOpinions.removeAll();
		try {
			TreeItem item = new TreeItem(treeOpinions, SWT.NONE);
			item.setText("Opinions");
			item.setExpanded(true);
			
			for (Iterator<Opinion> it = opinions.getContainsOpinion(); it
					.hasNext();) {
				addProfileOpinion(it.next(), item);
			}
		} catch (JastorException e) {
			logger.severe("Problem with showing stereotype profile: " + e);
		}
		
		

		expandTree(treeOpinions);
		
		TreeColumn[] columns =treeOpinions.getColumns();
		for (int i = 0; i < columns.length; i++)
			columns[i].pack();
	}
	
	private void expandTree(Tree tree) {
		expandTree(tree.getItems());
	}
	
	private void expandTree(TreeItem[] items) {
		for(int i = 0; i < items.length; i++ ) {
			items[i].setExpanded(true);
			expandTree(items[i].getItems());
		}
	}
	

	private void addStereotypeOpinion(Opinion opinion, TreeItem parent) {
		try {
			TreeItem item = new TreeItem(parent, SWT.NONE);
			item.setText(0, opinion.getIsAbout().toString());

			parent = item;
			item = new TreeItem(parent, SWT.NONE);
			item.setText(0, "Classification: ");
			item.setText(1, ""
					+ opinion.getHasClassification().resource().getLocalName());
			if (opinion.getAtIndividualProbability() != null) {
				item.setText(0, "probInd: ");
				item.setText(1, "" + opinion.getAtIndividualProbability());
			}
			if (opinion.getAtNormalizedProbability() != null) {
				item = new TreeItem(parent, SWT.NONE);
				item.setText(0, "probNorm: ");
				item.setText(1, "" + opinion.getAtInferredProbability());
			}
			if (opinion.getAtIndividualProbability() != null) {
				item = new TreeItem(parent, SWT.NONE);
				item.setText(0, "probInfer: ");
				item.setText(1, "" + opinion.getAtInferredProbability());
			}
		} catch (JastorException e) {
			logger.severe("Problem with showing stereotype profile: " + e);
		}
		


	}
	
	private void addProfileOpinion(Opinion opinion, TreeItem parent) {
		try {
			TreeItem item = new TreeItem(parent, SWT.NONE);
			item.setText(0, opinion.getIsAbout().toString());

			parent = item;
			
			item = new TreeItem(parent, SWT.NONE);			
			item.setText(0, "Classification: ");
			if (opinion.getHasClassification() != null)  
				item.setText(1, opinion.getHasClassification().resource().getLocalName());
			else
				item.setText(1, Classification.NotClassified.getLocalName());
					
			if (opinion.getAtIndividualProbability() != null) {
				item = new TreeItem(parent, SWT.NONE);
				item.setText(0, "probInd: ");
				item.setText(1, "" + opinion.getAtIndividualProbability());
			}
			if (opinion.getAtNormalizedProbability() != null) {
				item = new TreeItem(parent, SWT.NONE);
				item.setText(0, "probNorm: ");
				item.setText(1, "" + opinion.getAtNormalizedProbability());
			}
			if (opinion.getAtInferredProbability() != null) {
				item = new TreeItem(parent, SWT.NONE);
				item.setText(0, "probInfer: ");
				item.setText(1, "" + opinion.getAtInferredProbability());
			}
		} catch (JastorException e) {
			logger.severe("Problem with showing stereotype profile: " + e);
		}

	}

	private void addCategory(Tree tree, TreeItem parentItem, Category category) {
		TreeItem item = null;
		if (parentItem == null)
			item = new TreeItem(tree, SWT.NONE);
		else
			item = new TreeItem(parentItem, SWT.NONE);

		item.setText(0, category.getName());

		Collection<Category> subs = category.getSubCategories();

		if (subs.isEmpty()) {
			item.setData(category.getData());
			item.setText(1, (String) category.getData());
		}

		for (Iterator<Category> it = subs.iterator(); it.hasNext();)
			addCategory(tree, item, it.next());
	}

	private void log(String msg) {
		msg = format.format(new Date()) + " : " + msg;
		comboLog.add(msg, 0);
		comboLog.select(0);
	}

	/*
	 * ---------------------------------------------------------------------------------------
	 */

	/**
	 * Represents a category of items. 
	 */
	class Category {
		private String name;
		private Map<String, Category> subCategories;
		private Category parent;
		private Object data;

		public Category(String name, Category parent) {
			this.name = name;
			this.parent = parent;
			// TreeMap implementation is used because it allows sorting
			// according to key-order.
			subCategories = new TreeMap<String, Category>();
			if (parent != null)
				parent.addSubCategory(this);
		}

		public Category getSubCategory(String name) {
			return subCategories.get(name);
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Collection<Category> getSubCategories() {
			return subCategories.values();
		}

		private void addSubCategory(Category subcategory) {
			subCategories.put(subcategory.name, subcategory);
		}

		public String getName() {
			return name;
		}

		public Category getParent() {
			return parent;
		}

		public Object getData() {
			return data;
		}
	}

	/*
	 * ---------------------------------------------------------------------------------------
	 */

	/**
	 * This method initializes compositeEvents	
	 *
	 */
	private void createCompositeEvents() {
		GridData gridData33 = new GridData();
		gridData33.grabExcessHorizontalSpace = true;
		gridData33.verticalAlignment = GridData.FILL;
		gridData33.horizontalAlignment = GridData.FILL;
		GridData gridData32 = new GridData();
		gridData32.horizontalAlignment = GridData.FILL;
		gridData32.grabExcessHorizontalSpace = true;
		gridData32.grabExcessVerticalSpace = false;
		gridData32.verticalAlignment = GridData.FILL;
		GridData gridData31 = new GridData();
		gridData31.horizontalAlignment = GridData.FILL;
		gridData31.grabExcessHorizontalSpace = true;
		gridData31.grabExcessVerticalSpace = true;
		gridData31.verticalAlignment = GridData.FILL;
		GridData gridData30 = new GridData();
		gridData30.horizontalAlignment = GridData.FILL;
		gridData30.grabExcessHorizontalSpace = true;
		gridData30.grabExcessVerticalSpace = true;
		gridData30.verticalAlignment = GridData.FILL;
		GridLayout gridLayout7 = new GridLayout();
		gridLayout7.numColumns = 2;
		compositeEvents = new Composite(sashFormHistory, SWT.NONE);
		compositeEvents.setLayout(gridLayout7);
		labelEvents = new Label(compositeEvents, SWT.NONE);
		labelEvents.setText("Events in the sessions");
		labelEvents.setLayoutData(gridData32);
		labelEventContext = new Label(compositeEvents, SWT.NONE);
		labelEventContext.setText("Context of the event");
		labelEventContext.setLayoutData(gridData33);
		tableEvents = new Table(compositeEvents, SWT.BORDER);
		tableEvents.setHeaderVisible(true);
		tableEvents.setLayoutData(gridData31);
		tableEvents.setLinesVisible(true);
		tableEventContext = new Table(compositeEvents, SWT.BORDER);
		tableEventContext.setHeaderVisible(true);
		tableEventContext.setLayoutData(gridData30);
		tableEventContext.setLinesVisible(true);
	}

	/**
	 * This method initializes compositeSessions	
	 *
	 */
	private void createCompositeSessions() {
		GridData gridData9 = new GridData();
		gridData9.horizontalAlignment = GridData.FILL;
		gridData9.grabExcessHorizontalSpace = true;
		gridData9.grabExcessVerticalSpace = true;
		gridData9.heightHint = -1;
		gridData9.widthHint = -1;
		gridData9.verticalAlignment = GridData.FILL;
		GridData gridData8 = new GridData();
		gridData8.horizontalAlignment = GridData.FILL;
		gridData8.grabExcessHorizontalSpace = true;
		gridData8.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout6 = new GridLayout();
		gridLayout6.numColumns = 1;
		compositeSessions = new Composite(sashFormHistory, SWT.NONE);
		compositeSessions.setLayout(gridLayout6);
		labelSessions = new Label(compositeSessions, SWT.NONE);
		labelSessions.setText("Sessions in DB");
		labelSessions.setLayoutData(gridData8);
		tableSessions = new Table(compositeSessions, SWT.BORDER);
		tableSessions.setHeaderVisible(true);
		tableSessions.setLayoutData(gridData9);
		tableSessions.setLinesVisible(true);
		
	}
	
	private final static String LAST_SORT_COLUMN = "last-sort-kolumn";  //  @jve:decl-index=0:
	private SashForm sashFormHistory = null;
	private SashForm sashFormRestaurants = null;
	private Composite compositeRestaurantsLeft = null;
	private Composite compositeRestaurantsRight = null;
	private Composite compositeStatisticsFilter = null;
	private CCombo cComboUsers = null;
	private CCombo cComboBehaviours = null;
	private CCombo cComboConcepts = null;
	
	private class Row {
		private String[] text;
		private Object data;
		public Object getData() { return data; }
		public String[] getText() { return text; }
		
		public Row(String[] text, Object data) {
			this.text = text;
			this.data = data;
		}
		
		
	}

	//toggled -- if false, then always direction of sorting will be the same
	private void sort(Table table, int column) {
		if(table.getItemCount() <= 1) return;

		TableItem[] items = table.getItems();
		java.util.List<Row> rows = new ArrayList<Row>();
		
		for(int i = 0; i < items.length; i++) {
			String[] texts = new String[table.getColumnCount()];
			for(int j = 0; j < table.getColumnCount(); j++) {
				texts[j] = items[i].getText(j);
			}
			Row row = new Row(texts, items[i].getData());
			rows.add(row);
		}
		
		Collections.sort(rows, new RowComparator(column));
		
		Integer lastSortColumn = (Integer) table.getData(LAST_SORT_COLUMN);
		if (lastSortColumn == null)
			lastSortColumn = -1;
		
		if (lastSortColumn != column) {
			table.setSortColumn(table.getColumn(column));
			table.setSortDirection(SWT.DOWN);
			for (int i = 0; i < rows.size(); i++) {
				items[i].setText(rows.get(i).getText());
				items[i].setData(rows.get(i).getData());
			}
			lastSortColumn = column;
		} else {
			// reverse order if the current column is selected again
			table.setSortDirection(SWT.UP);
			int j = rows.size() -1;
			for (int i = 0; i < rows.size(); i++) {
				items[i].setText(rows.get(j).getText());
				items[i].setData(rows.get(j).getData());
				j--;
			}
			lastSortColumn = -1;
		}
		table.setData(LAST_SORT_COLUMN, lastSortColumn);
		
	}
	
	/**
	 * To compare entries (rows) by the given column
	 */
	private class RowComparator implements Comparator {
		private int column;
		
		/**
		 * Constructs a RowComparator given the column index
		 * @param col The index (starting at zero) of the column
		 */
		public RowComparator(int col) {
			column = col;
		}
		
		/**
		 * Compares two rows (type String[]) using the specified
		 * column entry.
		 * @param obj1 First row to compare
		 * @param obj2 Second row to compare
		 * @return negative if obj1 less than obj2, positive if
		 * 			obj1 greater than obj2, and zero if equal.
		 */
		public int compare(Object obj1, Object obj2) {
			Row row1 = (Row)obj1;
			Row row2 = (Row)obj2;
			
			// Are values numeric ?
			// TODO: Temporary solution: catching expection is time-consuming
			try {
				int i1 = Integer.parseInt(row1.getText()[column]);
				int i2 = Integer.parseInt(row2.getText()[column]);				
				return i1 < i2 ? -1 : (i1 == i2 ? 0 : 1);
			} catch (NumberFormatException e) {
				return row1.getText()[column].compareTo(row2.getText()[column]);
			}
			
			
		}
	}

	/**
	 * This method initializes sashFormHistory	
	 *
	 */
	private void createSashFormHistory() {
		GridData gridData6 = new GridData();
		gridData6.horizontalAlignment = GridData.FILL;
		gridData6.grabExcessHorizontalSpace = true;
		gridData6.grabExcessVerticalSpace = true;
		gridData6.verticalAlignment = GridData.FILL;
		sashFormHistory = new SashForm(compositeHistory, SWT.V_SCROLL | SWT.BORDER);
		sashFormHistory.setOrientation(SWT.VERTICAL);
		createCompositeSessions();
		sashFormHistory.setLayoutData(gridData6);
		createCompositeEvents();
	}

	/**
	 * This method initializes sashFormRestaurants	
	 *
	 */
	private void createSashFormRestaurants() {
		sashFormRestaurants = new SashForm(tabFolder, SWT.BORDER);
		createCompositeRestaurantsLeft();
		createCompositeRestaurantsRight();
	}

	/**
	 * This method initializes compositeRestaurantsLeft	
	 *
	 */
	private void createCompositeRestaurantsLeft() {
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.grabExcessHorizontalSpace = true;
		gridData4.verticalAlignment = GridData.CENTER;
		GridData gridData3 = new GridData();
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.verticalAlignment = GridData.FILL;		
		gridData3.grabExcessVerticalSpace = true;
		compositeRestaurantsLeft = new Composite(sashFormRestaurants, SWT.NONE);
		compositeRestaurantsLeft.setLayout(new GridLayout());
		labelRestaurants = new Label(compositeRestaurantsLeft, SWT.NONE);
		labelRestaurants.setText("Restaurants in DB");
		labelRestaurants.setLayoutData(gridData4);
		treeRestaurants = new Tree(compositeRestaurantsLeft, SWT.BORDER);
		treeRestaurants.setLayoutData(gridData3);
	}

	/**
	 * This method initializes compositeRestaurantsRight	
	 *
	 */
	private void createCompositeRestaurantsRight() {
		compositeRestaurantsRight = new Composite(sashFormRestaurants, SWT.NONE);
		compositeRestaurantsRight.setLayout(new GridLayout());
		GridData gridData5 = new GridData();
		gridData5.grabExcessHorizontalSpace = true;
		gridData5.verticalAlignment = GridData.CENTER;
		gridData5.horizontalAlignment = GridData.FILL;

		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.grabExcessVerticalSpace = true;
		gridData2.verticalAlignment = GridData.FILL;
		
		
		labelSingleRestaurant = new Label(compositeRestaurantsRight, SWT.NONE);
		labelSingleRestaurant.setText("Restaurant description");
		labelSingleRestaurant.setLayoutData(gridData5);
		
		tableSingleRestaurant = new Table(compositeRestaurantsRight, SWT.BORDER);
		tableSingleRestaurant.setHeaderVisible(true);
		tableSingleRestaurant.setLayoutData(gridData2);
		tableSingleRestaurant.setLinesVisible(true);
	}

	/**
	 * This method initializes compositeStatisticsFilter	
	 *
	 */
	private void createCompositeStatisticsFilter() {
		RowLayout rowLayout = new RowLayout();
		rowLayout.fill = true;
		rowLayout.justify = false;
		GridData gridData7 = new GridData();
		gridData7.horizontalAlignment = GridData.FILL;
		gridData7.grabExcessHorizontalSpace = true;
		gridData7.verticalAlignment = GridData.CENTER;
		compositeStatisticsFilter = new Composite(compositeStatistics, SWT.NONE);
		compositeStatisticsFilter.setLayoutData(gridData7);
		compositeStatisticsFilter.setLayout(rowLayout);
		cComboUsers = new CCombo(compositeStatisticsFilter, SWT.BORDER);
		cComboUsers.setVisibleItemCount(20);
		cComboUsers.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				filterStatistics();
			}
		});
		cComboBehaviours = new CCombo(compositeStatisticsFilter, SWT.BORDER);
		cComboBehaviours.setVisibleItemCount(10);
		cComboBehaviours
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						filterStatistics();
					}
				});
		cComboConcepts = new CCombo(compositeStatisticsFilter, SWT.BORDER);
		cComboConcepts.setVisibleItemCount(20);
		cComboConcepts
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						filterStatistics();
					}
				});
	}

	public static void main(String[] args) {

		System.out.println("This is Monitor for Agent-Based Travel Support System");
		System.out.println("(c) 2006 Maciej Gawinecki");
		
		/*
		 * Before this is run, be sure to set up the launch configuration
		 * (Arguments->VM Arguments) for the correct SWT library path in order
		 * to run with the SWT dlls. The dlls are located in the SWT plugin jar.
		 * For example, on Windows the Eclipse SWT 3.1 plugin jar is:
		 * installation_directory\plugins\org.eclipse.swt.win32_3.1.0.jar
		 */
		Display display = Display.getDefault();

		SystemMonitor thisClass = new SystemMonitor();
		thisClass.createSShell();
		thisClass.sShell.open();

		thisClass.initLayout();
		
		if (args.length >= 1 && args[0].equals("-read-all"))
			thisClass.initData();

		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		
		display.dispose();
	}
}
