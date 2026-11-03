package ecommerce;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    static class Product {
        String name, category, subCategory, company, description, imagePath;
        double price;

        Product(String name, String category, String subCategory,
                String company, double price, String description,
                String imagePath) {

            this.name = name;
            this.category = category;
            this.subCategory = subCategory;
            this.company = company;
            this.price = price;
            this.description = description;
            this.imagePath = imagePath;
        }
    }

    Product[] products = new Product[200];
    Product[] cart = new Product[200];

    int productCount = 0;
    int cartCount = 0;

    JComboBox<String> categoryBox;
    JComboBox<String> subCategoryBox;
    JPanel productPanel;
    JLabel cartLabel;
    JLabel productCountLabel;
    JTextField searchField;

    String[] categories = {
        "Electronics", "Clothing", "Furniture",
        "Groceries", "Home Decor"
    };

    String[][] subCategories = {
        {"Mobiles", "Laptops", "Speakers", "Earphones"},
        {"Mens Wear", "Womens Wear", "Kids Wear", "Footwear"},
        {"Sofas", "Beds", "Tables", "Chairs"},
        {"Fruits", "Dairy", "Beverages", "Snacks"},
        {"Lighting", "Wall Art", "Curtains", "Vases"}
    };

    String[][] productData = {

        {
            "Samsung Galaxy S24|Samsung",
            "iPhone 15|Apple",
            "OnePlus 12|OnePlus",
            "Google Pixel 8|Google",
            "Vivo V30|Vivo",
            "Oppo Reno 11|Oppo",
            "Realme 12 Pro|Realme",
            "Redmi Note 13|Xiaomi",
            "Motorola Edge 50|Motorola",
            "Nothing Phone 2|Nothing"
        },

        {
            "HP Pavilion 15|HP",
            "Dell Inspiron 15|Dell",
            "Lenovo IdeaPad Slim 3|Lenovo",
            "ASUS Vivobook 15|ASUS",
            "Acer Aspire 5|Acer",
            "HP 15s|HP",
            "Dell Vostro 3520|Dell",
            "Lenovo ThinkBook 15|Lenovo",
            "ASUS TUF Gaming|ASUS",
            "Acer Nitro V|Acer"
        },

        {
            "JBL Flip 6|JBL",
            "Sony SRS-XB23|Sony",
            "Boat Stone 1200|Boat",
            "Bose SoundLink Flex|Bose",
            "Marshall Emberton II|Marshall",
            "JBL Charge 5|JBL",
            "Sony SRS-XE300|Sony",
            "Boat Stone 352|Boat",
            "Bose SoundLink Mini|Bose",
            "Zebronics Zeb-Sound|Zebronics"
        },

        {
            "Boat Airdopes 141|Boat",
            "AirPods 2|Apple",
            "OnePlus Buds 3|OnePlus",
            "Sony WF-C700N|Sony",
            "JBL Tune 230NC|JBL",
            "Realme Buds Air 5|Realme",
            "Oppo Enco Air 3|Oppo",
            "Noise Buds VS104|Noise",
            "Nothing Ear|Nothing",
            "Samsung Galaxy Buds FE|Samsung"
        },

        {
            "Levis Slim Fit Jeans|Levis",
            "Peter England Shirt|Peter England",
            "Allen Solly T-Shirt|Allen Solly",
            "Van Heusen Formal Shirt|Van Heusen",
            "Louis Philippe Shirt|Louis Philippe",
            "Roadster Jeans|Roadster",
            "Puma T-Shirt|Puma",
            "Nike Sports T-Shirt|Nike",
            "U.S. Polo Shirt|U.S. Polo",
            "Wrangler Jeans|Wrangler"
        },

        {
            "Biba Kurti|Biba",
            "W Kurta|W",
            "Libas Anarkali|Libas",
            "Aurelia Kurti|Aurelia",
            "Fabindia Dress|Fabindia",
            "AND Dress|AND",
            "Global Desi Kurti|Global Desi",
            "Van Heusen Top|Van Heusen",
            "Levis Womens Jeans|Levis",
            "H&M Womens Dress|H&M"
        },

        {
            "Allen Solly Kids Shirt|Allen Solly",
            "Max Kids T-Shirt|Max",
            "H&M Kids Dress|H&M",
            "Mothercare Kids Wear|Mothercare",
            "United Colors Kids|United Colors",
            "Pantaloons Kids Wear|Pantaloons",
            "FirstCry Kids Dress|FirstCry",
            "Nike Kids T-Shirt|Nike",
            "Adidas Kids Wear|Adidas",
            "Puma Kids Wear|Puma"
        },

        {
            "Nike Air Max|Nike",
            "Adidas Superstar|Adidas",
            "Puma Running Shoes|Puma",
            "Skechers Go Walk|Skechers",
            "Reebok Classic|Reebok",
            "Bata Formal Shoes|Bata",
            "Woodland Shoes|Woodland",
            "Campus Running Shoes|Campus",
            "Sparx Sports Shoes|Sparx",
            "Red Tape Sneakers|Red Tape"
        },

        {
            "Urban Ladder Sofa|Urban Ladder",
            "Wakefit Sofa|Wakefit",
            "Ikea Sofa|IKEA",
            "Pepperfry Sofa|Pepperfry",
            "Nilkamal Sofa|Nilkamal",
            "Home Centre Sofa|Home Centre",
            "Durian Sofa|Durian",
            "Godrej Sofa|Godrej",
            "Sleepyhead Sofa|Sleepyhead",
            "Furlenco Sofa|Furlenco"
        },

        {
            "Wakefit King Bed|Wakefit",
            "Ikea Double Bed|IKEA",
            "Urban Ladder Bed|Urban Ladder",
            "Pepperfry Bed|Pepperfry",
            "Nilkamal Bed|Nilkamal",
            "Durian King Bed|Durian",
            "Godrej Bed|Godrej",
            "Home Centre Bed|Home Centre",
            "Sleepyhead Bed|Sleepyhead",
            "Duroflex Bed|Duroflex"
        },

        {
            "Ikea Dining Table|IKEA",
            "Urban Ladder Table|Urban Ladder",
            "Pepperfry Table|Pepperfry",
            "Wakefit Study Table|Wakefit",
            "Nilkamal Table|Nilkamal",
            "Durian Dining Table|Durian",
            "Godrej Office Table|Godrej",
            "Home Centre Table|Home Centre",
            "Wooden Street Table|Wooden Street",
            "Royaloak Table|Royaloak"
        },

        {
            "Ikea Office Chair|IKEA",
            "Green Soul Chair|Green Soul",
            "Featherlite Chair|Featherlite",
            "Wakefit Chair|Wakefit",
            "Godrej Office Chair|Godrej",
            "Nilkamal Chair|Nilkamal",
            "Durian Chair|Durian",
            "Urban Ladder Chair|Urban Ladder",
            "Pepperfry Chair|Pepperfry",
            "Royaloak Chair|Royaloak"
        },

        {
            "Fresh Apples|Fresh Farm",
            "Fresh Bananas|Fresh Farm",
            "Fresh Mangoes|Fresh Farm",
            "Fresh Oranges|Fresh Farm",
            "Fresh Grapes|Fresh Farm",
            "Fresh Watermelon|Fresh Farm",
            "Fresh Papaya|Fresh Farm",
            "Fresh Pineapple|Fresh Farm",
            "Fresh Guava|Fresh Farm",
            "Fresh Pomegranate|Fresh Farm"
        },

        {
            "Amul Milk|Amul",
            "Amul Butter|Amul",
            "Amul Cheese|Amul",
            "Mother Dairy Milk|Mother Dairy",
            "Mother Dairy Curd|Mother Dairy",
            "Nandini Milk|Nandini",
            "Milma Milk|Milma",
            "Britannia Cheese|Britannia",
            "Milky Mist Curd|Milky Mist",
            "Heritage Milk|Heritage"
        },

        {
            "Coca Cola|Coca Cola",
            "Pepsi|Pepsi",
            "Sprite|Sprite",
            "Fanta|Fanta",
            "Thums Up|Thums Up",
            "Red Bull|Red Bull",
            "Mountain Dew|Mountain Dew",
            "Maaza|Maaza",
            "Tropicana Juice|Tropicana",
            "Real Fruit Juice|Real"
        },

        {
            "Lays Potato Chips|Lays",
            "Kurkure|Kurkure",
            "Bingo Chips|Bingo",
            "Doritos|Doritos",
            "Haldiram Bhujia|Haldiram",
            "Too Yumm Chips|Too Yumm",
            "Unibic Cookies|Unibic",
            "Britannia Biscuits|Britannia",
            "Parle-G Biscuits|Parle",
            "Sunfeast Biscuits|Sunfeast"
        },

        {
            "Philips LED Bulb|Philips",
            "Syska LED Bulb|Syska",
            "Wipro LED Light|Wipro",
            "Havells LED Light|Havells",
            "Bajaj LED Bulb|Bajaj",
            "Crompton LED Light|Crompton",
            "Orient LED Light|Orient",
            "Surya LED Bulb|Surya",
            "Eveready LED Bulb|Eveready",
            "Panasonic LED Bulb|Panasonic"
        },

        {
            "Abstract Wall Painting|Home Decor",
            "Modern Wall Art|Home Decor",
            "Nature Wall Art|Home Decor",
            "Canvas Painting|Home Decor",
            "Mountain Painting|Home Decor",
            "Flower Wall Art|Home Decor",
            "Geometric Wall Art|Home Decor",
            "Traditional Painting|Home Decor",
            "Wooden Wall Art|Home Decor",
            "Metal Wall Art|Home Decor"
        },

        {
            "Cotton Curtains|Home Centre",
            "Blackout Curtains|IKEA",
            "Printed Curtains|Home Decor",
            "Window Curtains|Wakefit",
            "Door Curtains|Pepperfry",
            "Floral Curtains|Home Centre",
            "Plain Curtains|IKEA",
            "Designer Curtains|Urban Ladder",
            "Velvet Curtains|Durian",
            "Sheer Curtains|Amazon"
        },

        {
            "Ceramic Flower Vase|Home Centre",
            "Glass Flower Vase|IKEA",
            "Decorative Vase|Pepperfry",
            "Modern Ceramic Vase|Urban Ladder",
            "Wooden Vase|Home Decor",
            "Metal Vase|Home Decor",
            "White Flower Vase|Home Centre",
            "Golden Decorative Vase|Durian",
            "Table Vase|Wakefit",
            "Designer Vase|IKEA"
        }
    };
    double[][] productPrices = {

            // Mobiles
            {49999, 59900, 53999, 59999, 32999,
             29999, 24999, 15999, 27999, 29999},

            // Laptops
            {65990, 57990, 49990, 62990, 54990,
             45990, 64990, 69990, 79990, 89990},

            // Speakers
            {9999, 8999, 3999, 15999, 24999,
             12999, 11999, 2999, 7999, 2499},

            // Earphones
            {1499, 12999, 5999, 7999, 4999,
             3499, 2999, 1499, 9999, 5999},

            // Mens Wear
            {1999, 2499, 1499, 2299, 2999,
             1799, 1999, 2499, 2299, 1999},

            // Womens Wear
            {2499, 1999, 2299, 2499, 2999,
             1999, 2299, 2499, 2799, 2499},

            // Kids Wear
            {999, 799, 1499, 1299, 899,
             799, 1299, 1499, 1299, 999},

            // Footwear
            {8999, 7999, 4999, 6999, 5999,
             2499, 6999, 1999, 1499, 2999},

            // Sofas
            {29999, 34999, 39999, 29999, 24999,
             32999, 44999, 35999, 27999, 31999},

            // Beds
            {29999, 34999, 27999, 32999, 24999,
             39999, 29999, 35999, 28999, 31999},

            // Tables
            {12999, 9999, 14999, 6999, 7999,
             15999, 11999, 8999, 10999, 13999},

            // Chairs
            {7999, 5999, 8999, 6999, 9999,
             4999, 8999, 7999, 6999, 9999},

            // Fruits
            {199, 69, 149, 99, 199,
             299, 129, 149, 159, 249},

            // Dairy
            {65, 60, 120, 70, 65,
             60, 60, 120, 90, 70},

            // Beverages
            {45, 40, 40, 40, 45,
             120, 50, 55, 110, 100},

            // Snacks
            {30, 20, 30, 50, 90,
             30, 60, 40, 30, 40},

            // Lighting
            {199, 249, 299, 399, 199,
             349, 299, 179, 159, 299},

            // Wall Art
            {1499, 1299, 999, 1999, 1499,
             1299, 1799, 1999, 1499, 2499},

            // Curtains
            {1299, 1799, 999, 1499, 899,
             1399, 1199, 1999, 2499, 1599},

            // Vases
            {699, 899, 599, 999, 799,
             699, 499, 1299, 599, 999}
        };

    public Main() {

        setTitle("Simple E-Commerce Application");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createProducts();
        createWindow();

        setVisible(true);

        JOptionPane.showMessageDialog(
            this,
            "Welcome to My Shopping Store!\n\n" +
            "Select a category and sub-category to start shopping.",
            "Welcome",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // CREATE 200 PRODUCTS

    void createProducts() {

        for (int i = 0; i < categories.length; i++) {

            for (int j = 0; j < subCategories[i].length; j++) {

                int dataIndex = i * 4 + j;

                for (int k = 0; k < 10; k++) {

                    String data = productData[dataIndex][k];

                    int position = data.indexOf("|");

                    String name = data.substring(0, position);
                    String company = data.substring(position + 1);

                    double price = productPrices[dataIndex][k];

                    String subCategory = subCategories[i][j];

                    String description =
                        "Good quality " + subCategory +
                        " product suitable for daily use.";

                    String imagePath =
                        "images/" + subCategory + ".jpg";

                    products[productCount] = new Product(
                        name,
                        categories[i],
                        subCategory,
                        company,
                        price,
                        description,
                        imagePath
                    );

                    productCount++;
                }
            }
        }
    }

    // CREATE WINDOW

    void createWindow() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel(
            "My Shopping Store",
            JLabel.CENTER
        );

        title.setFont(
            new Font("Arial", Font.BOLD, 24)
        );

        add(title, BorderLayout.NORTH);

        JPanel topPanel = new JPanel();

        categoryBox = new JComboBox<>(categories);

        subCategoryBox =
            new JComboBox<>(subCategories[0]);

        categoryBox.addActionListener(
            e -> changeSubCategories()
        );

        subCategoryBox.addActionListener(
            e -> showProducts()
        );

        topPanel.add(new JLabel("Category:"));
        topPanel.add(categoryBox);

        topPanel.add(new JLabel("Sub-category:"));
        topPanel.add(subCategoryBox);

        cartLabel = new JLabel("Cart: 0 items");
        topPanel.add(cartLabel);

        productCountLabel =
            new JLabel("Products: 10");
        topPanel.add(productCountLabel);

        searchField = new JTextField(15);
        topPanel.add(searchField);

        JButton searchButton =
            new JButton("Search");

        searchButton.addActionListener(
            e -> searchProducts()
        );

        topPanel.add(searchButton);

        JButton cartButton =
            new JButton("View Cart");

        cartButton.addActionListener(
            e -> viewCart()
        );

        topPanel.add(cartButton);

        JButton homeButton =
            new JButton("Home");

        homeButton.addActionListener(
            e -> goHome()
        );

        topPanel.add(homeButton);

        add(topPanel, BorderLayout.SOUTH);

        productPanel = new JPanel();

        productPanel.setLayout(
            new GridLayout(0, 2, 10, 10)
        );

        add(
            new JScrollPane(productPanel),
            BorderLayout.CENTER
        );

        showProducts();
    }

    // CHANGE CATEGORY

    void changeSubCategories() {

        int index =
            categoryBox.getSelectedIndex();

        subCategoryBox.removeAllItems();

        for (String sub : subCategories[index]) {
            subCategoryBox.addItem(sub);
        }

        showProducts();
    }

    // HOME

    void goHome() {

        categoryBox.setSelectedIndex(0);

        subCategoryBox.removeAllItems();

        for (String sub : subCategories[0]) {
            subCategoryBox.addItem(sub);
        }

        subCategoryBox.setSelectedIndex(0);

        searchField.setText("");

        showProducts();
    }

    // SHOW PRODUCTS

    void showProducts() {

        if (productPanel == null ||
            subCategoryBox.getSelectedItem() == null) {
            return;
        }

        productPanel.removeAll();

        String category =
            (String) categoryBox.getSelectedItem();

        String subCategory =
            (String) subCategoryBox.getSelectedItem();

        int count = 0;

        for (int i = 0; i < productCount; i++) {

            Product p = products[i];

            if (p.category.equals(category) &&
                p.subCategory.equals(subCategory)) {

                addProductToPanel(p);
                count++;
            }
        }

        productCountLabel.setText(
            "Products: " + count
        );

        productPanel.revalidate();
        productPanel.repaint();
    }

    // SEARCH

    void searchProducts() {

        String text =
            searchField.getText()
            .trim()
            .toLowerCase();

        if (text.isEmpty()) {
            showProducts();
            return;
        }

        productPanel.removeAll();

        String category =
            (String) categoryBox.getSelectedItem();

        String subCategory =
            (String) subCategoryBox.getSelectedItem();

        int count = 0;

        for (int i = 0; i < productCount; i++) {

            Product p = products[i];

            if (p.name.toLowerCase().contains(text)) {

                addProductToPanel(p);
                count++;
            }
        }

        productCountLabel.setText(
            "Products: " + count
        );

        productPanel.revalidate();
        productPanel.repaint();
    }

    // PRODUCT PANEL

    void addProductToPanel(Product p) {

        JPanel panel =
            new JPanel(new GridLayout(9, 1));

        panel.setBorder(
            BorderFactory.createLineBorder(Color.GRAY)
        );

        ImageIcon icon =
            new ImageIcon(p.imagePath);

        JLabel image =
            new JLabel(icon, JLabel.CENTER);

        image.setPreferredSize(
            new Dimension(150, 100)
        );

        panel.add(image);

        JLabel name =
            new JLabel(p.name, JLabel.CENTER);

        name.setFont(
            new Font("Arial", Font.BOLD, 15)
        );

        panel.add(name);

        panel.add(
            new JLabel("Company: " + p.company)
        );

        panel.add(
            new JLabel("Category: " + p.subCategory)
        );

        panel.add(
            new JLabel("Price: Rs. " + p.price)
        );

        panel.add(
            new JLabel("Rating: ★★★★☆")
        );

        panel.add(
            new JLabel("Description: " + p.description)
        );

        JButton details =
            new JButton("View Details");

        details.addActionListener(
            e -> viewProductDetails(p)
        );

        panel.add(details);

        JButton add =
            new JButton("Add to Cart");

        add.addActionListener(
            e -> addToCart(p)
        );

        panel.add(add);

        productPanel.add(panel);
    }

    // PRODUCT DETAILS

    void viewProductDetails(Product p) {

        JPanel panel =
            new JPanel(new GridLayout(6, 1));

        ImageIcon icon =
            new ImageIcon(p.imagePath);

        panel.add(
            new JLabel(icon, JLabel.CENTER)
        );

        JLabel name =
            new JLabel(p.name, JLabel.CENTER);

        name.setFont(
            new Font("Arial", Font.BOLD, 18)
        );

        panel.add(name);

        panel.add(
            new JLabel("Company: " + p.company)
        );

        panel.add(
            new JLabel("Category: " +
                       p.category)
        );

        panel.add(
            new JLabel("Sub-category: " +
                       p.subCategory)
        );

        panel.add(
            new JLabel("Price: Rs. " +
                       p.price)
        );

        JOptionPane.showMessageDialog(
            this,
            panel,
            "Product Details",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // ADD TO CART

    void addToCart(Product p) {

        if (cartCount >= cart.length) {
            JOptionPane.showMessageDialog(
                this,
                "Cart is full!"
            );
            return;
        }

        cart[cartCount] = p;
        cartCount++;

        cartLabel.setText(
            "Cart: " + cartCount + " items"
        );

        JOptionPane.showMessageDialog(
            this,
            p.name + " added to cart!"
        );
    }

    // VIEW CART

    void viewCart() {

        if (cartCount == 0) {

            JOptionPane.showMessageDialog(
                this,
                "Your cart is empty."
            );

            return;
        }

        JPanel panel =
            new JPanel(new GridLayout(
                cartCount + 2, 1
            ));

        double total = 0;

        for (int i = 0; i < cartCount; i++) {

            Product p = cart[i];

            panel.add(
                new JLabel(
                    (i + 1) + ". " +
                    p.name +
                    " - Rs. " +
                    p.price
                )
            );

            total += p.price;
        }

        panel.add(
            new JLabel("Total: Rs. " + total)
        );

        JButton checkout =
            new JButton("Checkout");

        checkout.addActionListener(
            e -> payment()
        );

        panel.add(checkout);

        JButton remove =
            new JButton("Remove Item");

        remove.addActionListener(
            e -> removeItem()
        );

        panel.add(remove);

        JButton clear =
            new JButton("Clear Cart");

        clear.addActionListener(
            e -> clearCart()
        );

        panel.add(clear);

        JOptionPane.showMessageDialog(
            this,
            panel,
            "Shopping Cart",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // REMOVE ITEM

    void removeItem() {

        if (cartCount == 0) {
            JOptionPane.showMessageDialog(
                this,
                "Cart is empty."
            );
            return;
        }

        String[] items =
            new String[cartCount];

        for (int i = 0; i < cartCount; i++) {
            items[i] =
                (i + 1) + ". " +
                cart[i].name;
        }

        String selected =
            (String) JOptionPane.showInputDialog(
                this,
                "Select product to remove:",
                "Remove Item",
                JOptionPane.QUESTION_MESSAGE,
                null,
                items,
                items[0]
            );

        if (selected == null)
            return;

        int index =
            Integer.parseInt(
                selected.substring(
                    0,
                    selected.indexOf(".")
                )
            ) - 1;

        for (int i = index; i < cartCount - 1; i++) {
            cart[i] = cart[i + 1];
        }

        cart[cartCount - 1] = null;
        cartCount--;

        cartLabel.setText(
            "Cart: " + cartCount + " items"
        );

        JOptionPane.showMessageDialog(
            this,
            "Item removed from cart."
        );
    }

    // CLEAR CART

    void clearCart() {

        if (cartCount == 0) {

            JOptionPane.showMessageDialog(
                this,
                "Cart is already empty."
            );

            return;
        }

        int choice =
            JOptionPane.showConfirmDialog(
                this,
                "Do you want to clear the cart?",
                "Clear Cart",
                JOptionPane.YES_NO_OPTION
            );

        if (choice == JOptionPane.YES_OPTION) {

            for (int i = 0; i < cartCount; i++) {
                cart[i] = null;
            }

            cartCount = 0;

            cartLabel.setText(
                "Cart: 0 items"
            );

            JOptionPane.showMessageDialog(
                this,
                "Cart cleared successfully."
            );
        }
    }

    // PAYMENT

    void payment() {

        if (cartCount == 0) {

            JOptionPane.showMessageDialog(
                this,
                "Cart is empty."
            );

            return;
        }

        double total = 0;

        for (int i = 0; i < cartCount; i++) {
            total += cart[i].price;
        }

        String[] methods = {
            "UPI",
            "Credit Card",
            "Debit Card",
            "Cash on Delivery"
        };

        String method =
            (String) JOptionPane.showInputDialog(
                this,
                "Total Amount: Rs. " + total +
                "\nSelect Payment Method:",
                "Payment",
                JOptionPane.QUESTION_MESSAGE,
                null,
                methods,
                methods[0]
            );

        if (method == null)
            return;

        String orderId =
            "ORD" +
            (int)(Math.random() * 90000 + 10000);

        JOptionPane.showMessageDialog(
            this,
            "Payment Successful!\n\n" +
            "Order ID: " + orderId +
            "\nAmount: Rs. " + total +
            "\nPayment: " + method +
            "\n\nThank you for shopping!"
        );

        for (int i = 0; i < cartCount; i++) {
            cart[i] = null;
        }

        cartCount = 0;

        cartLabel.setText(
            "Cart: 0 items"
        );
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> new Main()
        );
    }
}