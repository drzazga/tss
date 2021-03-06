
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

/*****************************************************************************
 * Source code information
 * -----------------------
 * Package            ibspan.tss.domain.vocabulary
 * Created            27 sie 2006 04:45
 *****************************************************************************/

// Package
///////////////////////////////////////
package ibspan.tss.domain.vocabulary;


// Imports
///////////////////////////////////////
import com.hp.hpl.jena.rdf.model.*;



/**
 * Vocabulary definitions from file:ontology/location.owl
 * @author Auto-generated by jena.schemagen on 27 sie 2006 04:45
 */
public class LocationVocabulary {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static Model m_model = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://www.ibspan.waw.pl/tss/Location#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    

    // Vocabulary properties
    ///////////////////////////

    public static final Property feature = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#feature" );
    
    public static final Property accessibility = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#accessibility" );
    
    public static final Property restaurantCategory = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#restaurantCategory" );
    
    public static final Property indexPoint = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#indexPoint" );
    
    public static final Property restaurantService = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#restaurantService" );
    
    public static final Property attractionCategory = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#attractionCategory" );
    
    public static final Property dress = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#dress" );
    
    public static final Property reservations = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#reservations" );
    
    public static final Property parking = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#parking" );
    
    public static final Property alcohol = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#alcohol" );
    
    public static final Property locationCategory = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#locationCategory" );
    
    public static final Property cuisine = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#cuisine" );
    
    public static final Property hasDinerReview = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#hasDinerReview" );
    
    public static final Property dinnerPrice = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#dinnerPrice" );
    
    public static final Property lunchPrice = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#lunchPrice" );
    
    public static final Property smoking = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#smoking" );
    
    public static final Property breakfastPrice = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#breakfastPrice" );
    
    public static final Property accepts = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#accepts" );
    
    public static final Property state = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#state" );
    
    public static final Property locationPath = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#locationPath" );
    
    public static final Property zip = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#zip" );
    
    public static final Property recommendedDishes = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#recommendedDishes" );
    
    public static final Property clientele = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#clientele" );
    
    public static final Property reservationURL = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#reservationURL" );
    
    public static final Property parsedHours = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#parsedHours" );
    
    public static final Property streetAddress = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#streetAddress" );
    
    public static final Property fax = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#fax" );
    
    public static final Property largestParty = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#largestParty" );
    
    public static final Property hours = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#hours" );
    
    public static final Property capacity = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#capacity" );
    
    public static final Property crossStreet = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#crossStreet" );
    
    public static final Property city = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#city" );
    
    public static final Property menuURL = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#menuURL" );
    
    public static final Property URL = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#URL" );
    
    public static final Property neighborhood = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#neighborhood" );
    
    public static final Property title = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#title" );
    
    public static final Property country = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#country" );
    
    public static final Property deliveryURL = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#deliveryURL" );
    
    public static final Property phone = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#phone" );
    
    public static final Property accessibilityNotes = m_model.createProperty( "http://www.ibspan.waw.pl/tss/Location#accessibilityNotes" );
    

    // Vocabulary classes
    ///////////////////////////

    public static final Resource Location = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#Location" );
    
    public static final Resource IndexPointCode = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#IndexPointCode" );
    
    public static final Resource AttractionCategoryCode = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#AttractionCategoryCode" );
    
    public static final Resource LocationCategoryCode = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#LocationCategoryCode" );
    

    // Vocabulary individuals
    ///////////////////////////

    public static final Resource ExpresswayLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ExpresswayLocation" );
    
    public static final Resource TourAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#TourAttraction" );
    
    public static final Resource BridgeAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#BridgeAttraction" );
    
    public static final Resource MuseumAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#MuseumAttraction" );
    
    public static final Resource HistoricBuildingAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#HistoricBuildingAttraction" );
    
    public static final Resource NightlifeAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#NightlifeAttraction" );
    
    public static final Resource RailStationIndexPoint = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#RailStationIndexPoint" );
    
    public static final Resource SuburbanLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#SuburbanLocation" );
    
    public static final Resource AquariumAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#AquariumAttraction" );
    
    public static final Resource ShoppingAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ShoppingAttraction" );
    
    public static final Resource LakeLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#LakeLocation" );
    
    public static final Resource MarinaAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#MarinaAttraction" );
    
    public static final Resource GulfLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#GulfLocation" );
    
    public static final Resource WaterfrontAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#WaterfrontAttraction" );
    
    public static final Resource SchoolAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#SchoolAttraction" );
    
    public static final Resource UniversityAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#UniversityAttraction" );
    
    public static final Resource AmusementParkAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#AmusementParkAttraction" );
    
    public static final Resource SportsAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#SportsAttraction" );
    
    public static final Resource RaceTrackAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#RaceTrackAttraction" );
    
    public static final Resource OtherAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#OtherAttraction" );
    
    public static final Resource MountainAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#MountainAttraction" );
    
    public static final Resource ResortAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ResortAttraction" );
    
    public static final Resource ZooAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ZooAttraction" );
    
    public static final Resource OceanfrontLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#OceanfrontLocation" );
    
    public static final Resource TournamentAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#TournamentAttraction" );
    
    public static final Resource TrainStationAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#TrainStationAttraction" );
    
    public static final Resource StudioAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#StudioAttraction" );
    
    public static final Resource PierAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#PierAttraction" );
    
    public static final Resource BoatDockAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#BoatDockAttraction" );
    
    public static final Resource CrossStreetIndexPoint = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CrossStreetIndexPoint" );
    
    public static final Resource AirportAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#AirportAttraction" );
    
    public static final Resource WaterParkAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#WaterParkAttraction" );
    
    public static final Resource BeachfrontLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#BeachfrontLocation" );
    
    public static final Resource SubwayStationIndexPoint = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#SubwayStationIndexPoint" );
    
    public static final Resource SouthLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#SouthLocation" );
    
    public static final Resource LandmarkAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#LandmarkAttraction" );
    
    public static final Resource CarRentalLocationAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CarRentalLocationAttraction" );
    
    public static final Resource CityEventAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CityEventAttraction" );
    
    public static final Resource GalleryAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#GalleryAttraction" );
    
    public static final Resource WineryAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#WineryAttraction" );
    
    public static final Resource ResortLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ResortLocation" );
    
    public static final Resource NorthLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#NorthLocation" );
    
    public static final Resource PalaceAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#PalaceAttraction" );
    
    public static final Resource FactoryAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#FactoryAttraction" );
    
    public static final Resource ChurchAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ChurchAttraction" );
    
    public static final Resource SkiAreaAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#SkiAreaAttraction" );
    
    public static final Resource BusStationAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#BusStationAttraction" );
    
    public static final Resource BusinessLocationAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#BusinessLocationAttraction" );
    
    public static final Resource CasinoAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CasinoAttraction" );
    
    public static final Resource HighwayExitIndexPoint = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#HighwayExitIndexPoint" );
    
    public static final Resource CityCenterAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CityCenterAttraction" );
    
    public static final Resource ParkAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ParkAttraction" );
    
    public static final Resource RestaurantAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#RestaurantAttraction" );
    
    public static final Resource EntertainmentDistrictAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#EntertainmentDistrictAttraction" );
    
    public static final Resource BeachLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#BeachLocation" );
    
    public static final Resource CanalAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CanalAttraction" );
    
    public static final Resource MountainLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#MountainLocation" );
    
    public static final Resource DowntownLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#DowntownLocation" );
    
    public static final Resource FarmAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#FarmAttraction" );
    
    public static final Resource CityDowntownAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CityDowntownAttraction" );
    
    public static final Resource CityIndexPoint = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CityIndexPoint" );
    
    public static final Resource SubwayStationAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#SubwayStationAttraction" );
    
    public static final Resource ConventionCenterAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ConventionCenterAttraction" );
    
    public static final Resource ConcertHallAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ConcertHallAttraction" );
    
    public static final Resource RiverAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#RiverAttraction" );
    
    public static final Resource HospitalAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#HospitalAttraction" );
    
    public static final Resource StadiumAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#StadiumAttraction" );
    
    public static final Resource CemeteryAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CemeteryAttraction" );
    
    public static final Resource LocalCompanyAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#LocalCompanyAttraction" );
    
    public static final Resource CollegeAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CollegeAttraction" );
    
    public static final Resource OceanAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#OceanAttraction" );
    
    public static final Resource ConferenceCenterAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ConferenceCenterAttraction" );
    
    public static final Resource TheaterAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#TheaterAttraction" );
    
    public static final Resource LakeAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#LakeAttraction" );
    
    public static final Resource WestLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#WestLocation" );
    
    public static final Resource CityLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#CityLocation" );
    
    public static final Resource AirportLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#AirportLocation" );
    
    public static final Resource ShoppingMallAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#ShoppingMallAttraction" );
    
    public static final Resource BeachAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#BeachAttraction" );
    
    public static final Resource RecreationCenterAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#RecreationCenterAttraction" );
    
    public static final Resource FairgroundAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#FairgroundAttraction" );
    
    public static final Resource TrolleyStationAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#TrolleyStationAttraction" );
    
    public static final Resource MonumentAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#MonumentAttraction" );
    
    public static final Resource EastLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#EastLocation" );
    
    public static final Resource OrchardAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#OrchardAttraction" );
    
    public static final Resource AuditoriumAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#AuditoriumAttraction" );
    
    public static final Resource LibraryAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#LibraryAttraction" );
    
    public static final Resource IntersectionIndexPoint = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#IntersectionIndexPoint" );
    
    public static final Resource RuralLocation = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#RuralLocation" );
    
    public static final Resource AirportIndexPoint = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#AirportIndexPoint" );
    
    public static final Resource HighwayIndexPoint = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#HighwayIndexPoint" );
    
    public static final Resource StoreAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#StoreAttraction" );
    
    public static final Resource MarketAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#MarketAttraction" );
    
    public static final Resource FestivalAttraction = m_model.createResource( "http://www.ibspan.waw.pl/tss/Location#FestivalAttraction" );
    
}

/*
    TODO: Fill in footer
*/

