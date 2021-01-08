Coverage: 80%
# IMS Project

Inventory management system using Java, MySQL and some other supporting technologies 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

You can find my Jira [here](https://rg6.atlassian.net/jira/software/projects/IMS/boards/1)

And my GitHub Repository[here](https://github.com/RGlossop/IMS-Starter)
### Prerequisites

[Java](https://www.java.com/en/download/)

For any Help installing java all documentation can be found here.

[Java install help](https://www.java.com/en/download/help/index_installing.html)

-------------------------------------  
[mySQL](https://dev.mysql.com/downloads/installer/)

For any help installing mySQL please all documentation can be found here

[Sql Help](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)

--------------------------------------  
[My SQL workbench](https://dev.mysql.com/downloads/workbench/)  

For help connecting workbench to sql check here  
[Workbench Help](https://www.inmotionhosting.com/support/website/connect-database-remotely-mysql-workbench/)

Hostname: Ensure this is local host  
Port: 3306  
Username: root  
Password: root

### Installing

A step by step series of examples that tell you how to get a development env running  

Ensure a database named ims is in your sql.  

Fork and clone repositry  
Or  
Clone repositry  
From [My Github](https://github.com/RGlossop/IMS-Starter)

run IMSRunnableJar.jar  from the Documentation folder

Enter username and password  
Type Customer  
Type Read

This will show all customers in the database.

## Running the tests
To Run the tests, right click the root folder in eclipse and choose Coverage as -> Junit test

### Unit Tests 

DAO Tests ensure that the DAO is connecting to a database and altering table data 

Example  

	public void testCreate() {
		final Customer created = new Customer(3L, "chris", "perrins");
		assertEquals(created, DAO.create(created));
	}

This tests that a customer has been created.  

Controller tests mock the methods for each Controller  

Example

	public void testCreate() {
		final String F_NAME = "barry", L_NAME = "scott";
		final Customer created = new Customer(F_NAME, L_NAME);
		Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);
		assertEquals(created, controller.create());
		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

This tests that the customer controller creates a custome.


## Deployment

in order to deploy this to a live server ensure a database named ims is available in sql.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

I used the style v0.0.0.0 for versioning

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Ryan Glossop** - *Updated and worked on the project* - [https://github.com/RGlossop]

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
