*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${BASE_URL}    http://localhost:8080/Movie_Ticket_Management

*** Test Cases ***
Fill Form Automation
    Open Browser    ${BASE_URL}/movie    chrome

    Wait Until Element Is Visible    id=name
    Input Text    id=name    Avengers2
    Input Text    id=genre    Action
    Input Text    id=price    200

    Click Button    id=submit

    Sleep    2s

    Log To Console    Movie form submitted successfully

    Close Browser