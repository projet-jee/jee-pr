<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
    <head>
        <meta charset="UTF-8" />
        <title>geoChat</title>
        <link rel="stylesheet" type="text/css" href="css/connex/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/connex/style.css" />
		<link rel="stylesheet" type="text/css" href="css/connex/animate-custom.css" />
    <body>
        <div class="container">



          
            <header>
                <h1>geo<span>Chat</span></h1>
				
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="inscription" method="post" autocomplete="on"> 
                                <h1>Sign up</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Your username </label>
                                    <input id="username" name="username" required="required" type="text" placeholder="myusername"/>
                                </p>

                                <p> 
                                    <label class="uname" data-icon="u" > Your e-mail </label>
                                    <input id="mail" name="mail" required="required" type="text" placeholder="mymail@"/>
                                </p>


                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                 <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                <label for="password">Photo</label>
									<input type="file" name="inp" size="chars"> 
									
								</p>
                                <p class="signin button"> 
									<input type="submit" value="Sign up"/> 
								</p>
                                 <p class="change_link">  
									Already a member ?
									<a href="connex" class="to_register"> Go and log in </a>
								</p>
                            </form>
                        </div>

                        
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>