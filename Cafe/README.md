# ☕ Simple explanation
Order management, creating a mini project that show the beverages at Caffe.

# ☕ An initial requirements
![요구사항](https://user-images.githubusercontent.com/51469989/113657769-9e218a80-96d9-11eb-9a96-35f4894efe11.JPG)

1. On the first run screen, the user should be able to select the product, output the selection information, and exit. <br>
2. In the Select Products window, user can select choose the some kind as Coffee, Ade, Smoothie. <br>
3. Users who choose a product type can check the detailed menu and price. <br>
4. Users should be able to the show the selected menu and price when selecting the "selection information output window" <br>

<hr>

### The screen configuration is as follows
![예상출력화면1](https://user-images.githubusercontent.com/51469989/113658105-5fd89b00-96da-11eb-9be1-d71f7870e293.JPG)
![예상출력화면2](https://user-images.githubusercontent.com/51469989/113658116-636c2200-96da-11eb-8507-b08ca7a8de2d.JPG)

# ☕ Actual implementation content
(https://github.com/semi0612/Java_Mini_Project/tree/main/Cafe/Console_Output) <br>
![메인화면과 한 사이클](https://user-images.githubusercontent.com/51469989/113666501-51927b00-96ea-11eb-88a2-b5c625ebac06.JPG) <br>
This screen is output at run time. <br>
User selected "Store Order" on the first screen and then selected the Products and number of products. <br>
Result shows the selected product name, purchase quantity, and estimated cumulative points and asks if user want to continue ordering. <br>

![Y선택시](https://user-images.githubusercontent.com/51469989/113667116-48ee7480-96eb-11eb-8d7c-2ae57ef32f20.JPG) <br>
User order will continue when user enter Y. <br>

![N선택시](https://user-images.githubusercontent.com/51469989/113667125-4a1fa180-96eb-11eb-92c7-9aee019a80d8.JPG) <br>
also, all orders, payment amount, accumulated points, and show thanks you for users. <br>

<hr>

# ☕ and... GUI using Swing
(https://github.com/semi0612/Java_Mini_Project/tree/main/Cafe/GUI_Output) <br>
Decided to create a GUI with the same function using the swing. <br>
The most basic type of order window without a database attached. <br>

### first screen
![메인화면](https://user-images.githubusercontent.com/51469989/113513548-3ff38b00-95a5-11eb-86d1-3fe563240a24.JPG) <br>
This is the main screen. Users can select "Store" or "Take out" at launch. <br>
(I wanted to get rid of the background color of the selection window and all the edge lines to give it a clean look) <br>

### The screen that will be displayed if "Store" is selected
![매장주문 선택시](https://user-images.githubusercontent.com/51469989/113513523-25b9ad00-95a5-11eb-9b03-a9d7be34d9af.JPG) <br>
This is the screen that will be displayed if the user has selected "Store" on the first screen. <br>
(I wanted to color it clean, but I don't know if it went well. haha..) <br>

### The screen that will be displayed if "Take out" is selected
![포장주문 선택시 팝업창](https://user-images.githubusercontent.com/51469989/113513734-10914e00-95a6-11eb-9ea1-168436d90f40.JPG) <br>
This is the screen that will be displayed if the user has selected "Take out" on the first screen. <br>
First, the "Prices will be added" notice will be printed in the pop-up window. <br>

![포장주문 화면](https://user-images.githubusercontent.com/51469989/113513613-85b05380-95a5-11eb-9c16-45839a024859.JPG) <br>
After that, Users will see a screen where you can order. <br>

### select the menu
![메뉴 수량 선택후 확인 누르면 창에 쓰여진다](https://user-images.githubusercontent.com/51469989/113513649-b42e2e80-95a5-11eb-97dc-291130fba50b.JPG) <br>
Selecting the menu to order disables the button, allowing you to select the quantity to order with - +. <br>
If you press OK after selecting the quantity, the menu name, unit price, quantity, and total will be written in the window below. <br>

### Order button
![주문 누르면 뜨는 팝업](https://user-images.githubusercontent.com/51469989/113513784-3a4a7500-95a6-11eb-9898-73432cbf4d6c.JPG) <br>
When you press the Order button, the user's order as a pop-up, showing the greeting and the points to be accumulated. <br>

### Other button
1. "초기화 " = the menu selection disappears
2. "닫기" = exit the program
3. "이전" = Return to main screen and select Take out/Store
