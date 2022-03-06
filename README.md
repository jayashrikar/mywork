# Assignment Setup Guidelines:
Download all the files mentioned in the git repository within the mywork/feature branch.
1. Install the latest version of IntelliJIDEA latest version (say 2021.3.1) and then create a new maven project.
2. Make sure you have Jdk 1.8 toolkit is installed in the machine and also scala@2.12.15 version also should be installed.
3. Select Maven project and provide any project name and GroupId, click next and Finish.
4. Once the project is created, Please rename the folder present in src/main/java to src/main/scala.
5. Once the renaming is done, please right-click on the project name (which will be in Bold letters) and go to Add Framework Support and select Scala check box. In Use Library - select scala version 2.12.15 (for example) if not click on create option and download scala 2.12.15.
6. Also, rename src/test/java to src/test/scala. Place the Scala_Adthena_Assignment.scala under src/main/scala and Scala_Adthena_AssignmentSpec.scala under src/test/scala.
7. Add/Replace the pom.xml file which you can find in the given git repository with the existing the file in your project (as the existing file doesn't have any dependencies in it).
8. Once the above steps are done, we can execute both the Scala_Adthena_Assignment.scala and its test file (Scala_Adthena_AssignmentSpec.scala).
9.  After executing Scala_Adthena_Assignment.scala, it will prompt for "priceBasket " and you can pass any item names to be added to basket list (say Milk, Apples, Soup, Bread) and it is case sensitive.
10.  Once we provide the list of items and click Enter, we can see the subtotal price before discount , the discounts if any and finally the totalprice after discount. 
11.  Also, the test file can be executed it will be passed as I have provided two test cases for subtotal price and totalprice after discount for a given set of items in the list and made the value to be equal to their respective values in Double type format i.e., 6.5 and 6.0 respectively and the test cases passed.

  
  
  
  
