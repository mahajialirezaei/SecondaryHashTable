package org.example;


public class Main {
    static DoubleHashTable doubleHashTable;

    public static void main(String[] args) {
        while (true) {
            try {
                worker.printStarLine();
                System.out.println(Colors.WHITE + "Choose Your Option");
                System.out.println(Colors.AQUA + "\n0." + Colors.ANSI_GREEN + " build Hash table or reset it)");

                System.out.println(Colors.NumColor() + "1." + Colors.ANSI_GREEN +" Insert key");
                System.out.println(Colors.NumColor()+ "2."+ Colors.ANSI_GREEN +" Search key");
                System.out.println(Colors.NumColor() + "3."+ Colors.ANSI_GREEN +" Delete key");
                System.out.println(Colors.NumColor() + "    31."+ Colors.ANSI_GREEN +"Delete key from First level ");
                System.out.println(Colors.NumColor() + "  32."+ Colors.ANSI_GREEN +"Delete key from Secondry level");
                System.out.println(Colors.NumColor() + "4. "+ Colors.ANSI_GREEN +"show Hash Table");
                System.out.println(Colors.NumColor() + "5."+ Colors.ANSI_GREEN +"quit");
                String[] input = worker.nextLine().split(" ");
                if ((input[0].matches("[1-4]") || input[0].matches("31|32")) && doubleHashTable == null) {
                    System.out.println(Colors.ANSI_RED + "You should build doubleHashTable First");
                    continue;
                }
                switch (input[0]) {
                    case "0" -> {
                        doubleHashTable = new DoubleHashTable(0);
                        doubleHashTable.build();
                    }
                    case "1" -> doubleHashTable.Insert(input);
                    case "2" -> doubleHashTable.Search(input);
                    case "3" -> doubleHashTable.Deleteboth(input);
                    case "4" -> doubleHashTable.show();
                    case "5" -> {
                        return;
                    }
                    case "31" -> {
                        if (!doubleHashTable.DeleteFirstTable(input)) {
                            System.out.println(Colors.ANSI_RED + "Not found");
                        }
                    }
                    case "32" -> {
                        if (!doubleHashTable.DeleteSecondaryTable(input)) {
                            System.out.println(Colors.ANSI_RED + "Not found");
                        }
                    }
                    default -> worker.invalidInput();
                }
            } catch (Exception e) {
                worker.invalidInput();
            }
        }
    }


}