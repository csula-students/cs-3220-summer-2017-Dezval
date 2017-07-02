// single state store
class Store {
    constructor(storage) {
        this.storage = storage; // assuming local storage will be passed in as storage
        // these are the key name you can use in Store
        this.CART_KEY = 'CART';
        this.QUEUE_KEY = 'QUEUE';
        this.FOODS_KEY = 'FOODS';
    }

    // you can get item by store.cartItems
    get cartItems() {
        return JSON.parse(this.storage.getItem(this.CART_KEY));
    }

    // to call setter, simply "assign" like store.cartItems = something
    set cartItems(cartItems) {
        this.storage.setItem(this.CART_KEY, JSON.stringify(cartItems));
    }

    get queue() {
        return JSON.parse(this.storage.getItem(this.QUEUE_KEY));
    }

    set queue(queue) {
        this.storage.setItem(this.QUEUE_KEY, JSON.stringify(queue));
    }

    get foods() {
        return JSON.parse(this.storage.getItem(this.FOODS_KEY));
    }

    set foods(foods) {
        this.storage.setItem(this.FOODS_KEY, JSON.stringify(foods));
    }
}

class Cart {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.items = this.store.cartItems;
        this.init();
    }

    init() {
        // Render a list of items under root element
        this.render();
        // TODO: attach remove cart items to rendered HTML
    }

    destroy() {
        // TODO: remove all the events attached from init
    }

    // remove an item from shopping cart
    removeItem(item) {
        // TODO: logic to remove an item from cart
        // call render method when the item is removed to update view
        this.render();
    }

    placeOrder() {
        // add item to statuses in store as status "in progress"
    }

    // render a list of item under root element
    render() {
        for (var i = 0; i < this.store.cartItems.length; i++){
            console.log(this.store.cartItems[i]);
        }
        // console.log(this.store.cartItems);
        let tbody = this.root.querySelector('tbody');

        // using innerHTML to render a list of table row item under tbody
        tbody.innerHTML = getHtmlForCart(this.store.cartItems);

        let deleteButtons = this.root.querySelectorAll('.delete-button');

        for (var i = 0; i < deleteButtons.length; i ++) {
            let deleteBttn = deleteButtons[i];
            deleteBttn.addEventListener('click', () => {
                alert('You are deleting' + deleteBttn);
                this.store.cartItems.splice(i,1);
                this.render();
            });
        }
    }

    getHtmlForCart(items){
        var innerHtml = '';
        for(var i = 0; i < items.length; i++){
            innerHtml +=
                "<tr>" +
                    "<td>" + items[i].name + "</td>" +
                    "<td>" + items[i].price + "</td>" +
                "</tr>";
        }
        return innerHtml;
    }
}

class CheckoutButton {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.onClick = () => this.addItemToCart();
        this.init();
    }

    init() {
        this.root.addEventListener('click', this.onClick);
    }

    destroy() {
        this.root.addEventListener('click', this.onClick);
    }

    addItemToCart() {
        // hint: you can use `dataset` to access data attributes
        // See passing data from HTML to JavaScript from course note
        let cartItems = this.store.cartItems || [];
        // TODO: replace with actual item
        console.log(this.root.dataset);
        cartItems.push({
            name: this.root.dataset.name,
            price: this.root.dataset.price
        });
        console.log(cartItems);
        this.store.cartItems = cartItems;
    }
}

class StatusTable {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        init();
    }

    init() {
        // attach click event listener to table header row on each column
        render();
    }

    destroy() {
        // remove all the events attached from init
    }

    sort(columnName) {
        // after sorting the array of statuses, re render item to update view
        render();
    }

    // render rows of items under table using root.innerHTML
    render() {

    }
}

// continue from Lab2 with Store, CheckoutButton, Cart components
class Inventory {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init () {
        this.render();
        // TODO: attach event listeners like click to remove items after rendering
    }

    destroy () {
        // TODO: remove event listeners added from the init above
    }

    removeItem (itemName) {
        // TODO: function to remove item given item name from store
    }

    render () {
        // using innerHTML to render inventory listing
    }
}

class Menu {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init () {
        this.render();
    }

    render () {
        // render a list of food menu from store using innerHTML

        for (var i = 0; i < this.store.foods.length; i++){
            console.log(this.store.foods[i]);
        }
        // console.log(this.store.cartItems);
        let tbody = this.root.querySelector('tbody');

        // using innerHTML to render a list of table row item under tbody
        tbody.innerHTML = getHtmlForCart(this.store.foods);

        let deleteButtons = this.root.querySelectorAll('.delete-button');

        for (var i = 0; i < deleteButtons.length; i ++) {
            let deleteBttn = deleteButtons[i];
            deleteBttn.addEventListener('click', () => {
                alert('You are deleting' + deleteBttn);
                this.store.foods.splice(i,1);
                this.render();
            });
        }


    }
}

class CreateFood {
    constructor(root, store) {
        this.root = root; // root should be the container of the form itself
        this.store = store;
        this.init();
    }

    init () {
        // attach click event to create button
        this.root.addEventListener('click', this.onClick);
    }

    createFood () {
        // will need to do querySelector to find out every single form element
        // to get their values before creating a new food
        // after creating a new food item, add it to store
        let foods = this.store.foods || [];
        foods.push({
            name: this.root.dataset.name,
            price: this.root.dataset.price
        });
        this.store.foods = foods;
    }
}

// DOMContentLoaded event will allow us to run the following function when
// everything is ready. Think of the following code will only be executed by
// the end of document
document.addEventListener('DOMContentLoaded', () => {
    // use querySelector to find the table element (preferably by id selector)
    // let statusTable = document.querySelector('');
    // use querySelector to find the cart element (preferably by id selector)

    let cart = document.querySelector('#cart-table');

    let checkoutButtons = document.querySelectorAll('.checkout-button');

    let store = new Store(window.localStorage);
    // if (table) {
    //     new StatusTable(table, store);
    // }
    if (cart) {
        new Cart(cart, store);
    }
    if (checkoutButtons && checkoutButtons.length) {
        for (var i = 0; i < checkoutButtons.length; i++) {
            new CheckoutButton(checkoutButtons[i], store);
        }
    }

});