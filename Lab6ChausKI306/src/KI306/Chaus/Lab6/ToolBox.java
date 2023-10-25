package KI306.Chaus.Lab6;
import java.util.ArrayList;

class ToolBox<T extends Tool> {
  private ArrayList<T> tools;

  public ToolBox() {
      tools = new ArrayList<>();
  }

  public T findMin() {
      if (!tools.isEmpty()) {
          T min = tools.get(0);
          for (int i = 1; i < tools.size(); i++) {
              if (tools.get(i).compareTo(min) < 0)
                  min = tools.get(i);
          }
          return min;
      }
      return null;
  }

  public void addTool(T tool) {
      tools.add(tool);
      System.out.print("tool added: ");
      tool.print();
  }

  public void removeTool(int i) {
      if (i >= 0 && i < tools.size()) {
          tools.remove(i);
          System.out.println("Tool removed at index " + i);
      } else {
          System.out.println("Invalid index. Cannot remove tool.");
      }
  }

  public void printContents() {
      if (!tools.isEmpty()) {
          for (T tool : tools) {
              tool.print();
          }
      } else {
          System.out.println("Tool box is empty. No tools available.");
      }
  }
}

class Screwdriver implements Tool {
  private String screwdriverType;
  private String screwdriverBrand;
  private double screwdriverCost;
  private int screwdriverSize;

  public Screwdriver(String sType, String sBrand, double sCost, int sSize) {
	  screwdriverType = sType;
	  screwdriverBrand = sBrand;
	  screwdriverCost = sCost;
	  screwdriverSize = sSize;
  }

  public String getScrewdriverType() {
      return screwdriverType;
  }

  public void setScrewdriverType(String type) {
	  screwdriverType = type;
  }

  public String getScrewdriverBrand() {
      return screwdriverBrand;
  }

  public void setScrewdriverBrand(String brand) {
	  screwdriverBrand = brand;
  }

  public double getScrewdriverCost() {
      return screwdriverCost;
  }

  public void setScrewdriverCost(double cost) {
	  screwdriverCost = cost;
  }

  public void setScrewdriverSize(int size) {
	  screwdriverSize = size;
  }

  public int getSize() {
      return screwdriverSize;
  }

  public int compareTo(Tool tool) {
      Integer s = screwdriverSize;
      return s.compareTo(tool.getSize());
  }

  public void print() {
      System.out.println("[Screwdriver]");
      System.out.println("  Type: " + screwdriverType);
      System.out.println("  Brand: " + screwdriverBrand);
      System.out.println("  Cost: " + screwdriverCost + " $");
      System.out.println("  Size: " + screwdriverSize);
      System.out.println();
  }
}


class Wrench implements Tool {
  private String wrenchBrand;
  private int wrenchWeight;
  private int wrenchSize;

  public Wrench(String wBrand, int wWeight, int wSize) {
	  wrenchBrand = wBrand;
	  wrenchWeight = wWeight;
	  wrenchSize = wSize;
  }

  public String getWrenchBrand() {
      return wrenchBrand;
  }
  public void setWrenchBrand(String brand) {
	  wrenchBrand = brand;
  }

  public int getWrenchWeight() {
      return wrenchWeight;
  }
  public void setWrenchWeight(int weight) {
	  wrenchWeight = weight;
  }

  public void SetWrenchSize(int size) {
	  wrenchSize = size;
  }

  public int getSize() {
      return wrenchSize;
  }
  public int compareTo(Tool tool) {
      Integer s = wrenchSize;
      return s.compareTo(tool.getSize());
  }
  public void print() {
      System.out.println("[Wrench]");
      System.out.println("  Brand: " + wrenchBrand);
      System.out.println("  Genre: " + wrenchWeight);
      System.out.println("  Size: " + wrenchSize);
      System.out.println();
  }
}

