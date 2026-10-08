# *** Settings ***
# Library    RequestsLibrary
#
# *** Variables ***
# ${BASE_URL}    http://localhost:8080/Movie_Ticket_Management
#
# *** Test Cases ***
# Check the movie page loaded
#     Create Session  movie_api  ${BASE_URL}
#
#     ${response}=  GET On Session   movie_api  /movie
#     Should Be Equal As Integers   ${response.status_code}  200
#     Log To Console  movie form page is opened
#
# Check the element page loaded
#     Create Session   movie_api    ${BASE_URL}
#
#
#     ${response}=  GET On Session   movie_api   /movie/1
#     Should Be Equal As Integers  ${response.status_code}  200
#     Log To Console   item get displayed
#
# Check wheather the Movie is Created
#     Create Session   movie_api    ${BASE_URL}
#      ${data}=  Create Dictionary
#         ...    name=Avengers
#         ...    genre=Action
#         ...    price=200
#
#     ${response}=   Post On Session    movie_api     /movie  data=${data}
#     Should Be Equal As Integers    ${response.status_code}  200
#     Log To Console   it is added to the mysql.
