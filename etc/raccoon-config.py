#
# authors: Adam Souzis, Michal Olczak
#

STYLESHEET = { ('html-media', 'welcome') : 'templates/html_standard_screen.rxsl',
               ('html-media', 'register-1') : 'templates/html_register_1_screen.rxsl',
               ('html-media', 'register-2') : 'templates/html_register_2_screen.rxsl',
							 ('html-media', 'register-success') : 'templates/html_standard_screen.rxsl',
							 ('html-media', 'login-1') : 'templates/html_login_1_screen.rxsl',
							 ('html-media', 'login-success') : 'templates/html_standard_screen.rxsl',
							 ('html-media', 'define-search') : 'templates/html_define_search_screen.rxsl',
               ('html-media', 'search') : 'templates/html_results_screen.rxsl',
							 ('html-media', 'show-details') : 'templates/html_details_screen.rxsl',
               ('html-media', 'show-backed-up-results') : 'templates/html_results_screen.rxsl',
               ('html-media', 'logout') : 'templates/html_standard_screen.rxsl'
             }
    

from rx import RxPathDom
 
actions = { "http-request": [
     #if the file is an OWL file, parse and transform it with STYLESHEET
     Action( 
        ["f:if(wf:file-exists($_name) and f:ends-with($_name, '.owl'),true())"], 
        lambda result, kw, contextNode, retVal, invokeRxSLT=RxPathDom.invokeRxSLT, ss=STYLESHEET: invokeRxSLT( kw["_name"], ss[( kw["media-type"],kw["action-name"] )] ) 
     ), 
     #if its not a OWL file, just return the contents of the file
     Action( 
        ["f:if(wf:file-exists($_name) and not(f:ends-with($_name, '.owl')), wf:openurl(concat('file:',$_name)))"], 
        lambda result, kw, contextNode, retVal: result
     )]
}


    