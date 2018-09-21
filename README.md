# Tech task from ICEBERG

REST API for coffee machine:
User can request a cup of coffee, coffee machine should return the cup and update it's state in accordance with ammounts of materials left
User can add water, milk, beans to the machine or perform machine cleaning

One cup of capuchino uses: 150ml of water, 100ml of Milk, 15mg of coffee beans

If there isn't enougth materials coffee machine should return an error and ask for water, milk, beans or cleaning
Once per 8 cups the machine requires cleaning
Coffee machine can hold 2 liters of water, 1 liter of milk and 100mg of coffee beans, if user tries to put into it more than possible
 there should be an overflow error (input validation)

Try to write clean and maintanable code, aply KISS, DRY, YAGNI principles
Specifiy documentation as if somebody else would integrate with this API
Write tests as you see fit
For additional points you can add additional options of coffee types (americano, espresso)

===

My coffee machine REST API

POST /addwater       - Add water in the machine whith given input value  
POST /addmilk        - Add milk in the machine whith given input value  
POST /addbeans 	     - Add coffee beans int the machine whith given input value  
GET  /parameters     - Get current values of all parameters of the coffee machine  
GET  /status         - Get the current status of the coffee machine  
POST /capuchino      - Make capuchino
POST /espresso       - Make espresso  
POST /americano      - Make americano  
POST /clean          - Cleaning the coffee machine  
