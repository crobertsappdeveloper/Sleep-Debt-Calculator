# Sleep-Debt-Calculator
Calculates the amount of hours the user has of sleep debt and also that they have overslept based on the optimal amount of hours of sleep per week and the values that the user has entered.

In order for this to work correctly the project must be named Sleep Debt Calculator and you need to create a new drawable resource called rectangle.xml

This app demonstrates how values from edit text boxes can be converted into integers which can then be used to create and display calculations baded on the input of the user. Rectangles are used around content to make the layout more presentable and separate the results and input sections.

Bugs/errors are eliminated as toasts are used to alert users if the values they enter are empty, 0 or too high (more than 24 as there are only 24 hours in a day for the context of this app). After the toasts alert the user to what error is made the app resets all values to 0 and exits the method that is being run for the calculation so that no calculations are performed with incorrect values.
