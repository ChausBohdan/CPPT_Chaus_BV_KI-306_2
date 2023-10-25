package KI306.Chaus.Lab6;

public class ToolBoxApp {
      public static void main(String[] args) {
			
			  ToolBox<? super Tool> suitcase = new ToolBox<>();
			  
			  System.out.println(); suitcase.addTool(new Screwdriver("Phillips",
			  "ExampleBrand", 25.99, 6)); suitcase.addTool(new Screwdriver("Philp",
			  "randI", 1.19, 11));
			  
			  suitcase.addTool(new Wrench("ExampleBrand", 500, 12)); suitcase.addTool(new
			 Wrench("LightTools", 300, 8)); suitcase.addTool(new Wrench("BigTools", 700,
			  24)); suitcase.removeTool(3);
			  
			  System.out.print("\nContents of Tool Box: \n"); suitcase.printContents();
			  
			  Tool minTool = suitcase.findMin();
			  System.out.print("\nThe smallest tool in the Tool box is: ");
			  minTool.print();
          
          
          
          
          MyTool<String> stringTool = new MyTool<>();
          stringTool.print_data("Hello, World!");

          MyTool<Integer> integerTool = new MyTool<>();
          integerTool.print_data(42);
          }
      }
