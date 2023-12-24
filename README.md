# Direct_to_Your_Door

<img src="photo1.png" alt="Alt Text" width="350" height="200">

Direct to Your Door is a Java-implemented prototype created for the 'Shipping for You' company, designed to efficiently supervise and manage various types of deliveries.
The system caters to a spectrum of delivery categories, encompassing standard, express, and business delivery modes.In addition , The system comprises members, each with their details, residential area (north, center, or south), and an array of deliveries of various types.

The main system consists of an array of managers, each responsible for subscribers in a specific region (north, center, or south). The system administrator has a username and password stored in variables within the administrator class.
After logging in, the system will show a menu.

### Main Managers Menu

1. **Managers:**

- Enables the addition of a manager to the system.
- Enables the addition of a vice manager to the system.

2.  **Subscription:**

- Allows the addition of subscription details to the manager's system.
- Provides functionality to delete a subscription using a subscription code.

3. **Retrieve Deliveries by Customer Code:**

   - Retrieves all encompassing standard, express, and business deliveries of a customer using their code in a JTable.

4. **Add New Shipment:**

   - Adds a new shipment to an existing customer's array in the array of the same manager.

5. **Delete Short Shipment:**

-It includes a brief shipment deletion form that utilizes a member code to remove the corresponding delivery from the system.

6. **Show Details About Last Shipment**

-

7. **Submenu:**
   - Contains a MenuItem for:
     - Displaying all short deliveries within a JTable.
     - Displaying details of all subscribers who ordered short delivery within a TextArea.
     - Listing all cities to which a short shipment was sent in the last 30 days.

### Guidelines

A. I made sure to give meaningful names.
B. I made sure to use the toString/getters/setters methods and not to use public type variables.
C. Pay attention when using the principle of inheritance and polymorphism and interfaces.
D. Pay attention to the connections between the departments. For example, a connection between a delivery and a subscriber, or a connection between an administrator and a subscriber, etc.

<img src="photo4.png" alt="Alt Text" width="350" height="200">
  <img src="photo3.png" alt="Alt Text" width="350" height="200">
<img src="photo2.png" alt="Alt Text" width="350" height="200">
