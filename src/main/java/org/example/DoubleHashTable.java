package org.example;

import java.util.ArrayList;

public class DoubleHashTable {
    private static final int SECONDARYTABLESIZE = 20;
    int size;
    ArrayList<ArrayList<DoubleSet>> hashTable = new ArrayList<>();

    public DoubleHashTable(int size) {
        this.size = size;
        hashTable = new ArrayList<>(size);
        this.sethashTable(size);
    }

    int hash1(int key) {
        return (int) (key + size * 3.71) % size;
    }

    int hash2(int key) {
        return (key * 41 + 1) % SECONDARYTABLESIZE;
    }

    void addKey(int key, String value) {
        int hash1 = hash1(key);
        try {
            if (hashTable.get(hash1).get(0) == null) {
                hashTable.get(hash1).set(0, new DoubleSet(key, value));
            } else {
                int hash2 = hash2(key);
                addcollisionkey(hash1, hash2, key, value);
            }
        } catch (Exception e) {
            System.out.println("warning");
            hashTable.set(hash1, new ArrayList<>(SECONDARYTABLESIZE));
            hashTable.get(hash1).add(new DoubleSet(key, value));
        }

    }

    private void addcollisionkey(int hash1, int hash2, int key, String value) {
        if (hash2 > hashTable.get(hash1).size()) {
            System.out.println("secondary Hash table is full");
            return;
        }
        try {
            if (hashTable.get(hash1).get(hash2) == null) {
                hashTable.get(hash1).set(hash2, new DoubleSet(key, value));
            } else {
                addcollisionkey(hash1, hash2 + 1, key, value);
            }
        } catch (Exception e) {
            hashTable.get(hash1).set(hash2, new DoubleSet(key, value));
        }
    }

    public void build() {
        while (true) {
            try {
                System.out.println(Colors.AQUA + "Buliding the Double Hash Table");
                System.out.println("Enter The Size:");
                int size = Integer.parseInt(worker.nextLine());
                this.sethashTable(size);
                worker.wasSuccessful();
                return;
            } catch (Exception e) {
                worker.invalidInput();
            }
        }
    }

    private void sethashTable(int size) {
        this.size = size;
        this.hashTable = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.hashTable.add(new ArrayList<>(SECONDARYTABLESIZE));
            for (int j = 0; j < SECONDARYTABLESIZE; j++) {
                this.hashTable.get(i).add(null);
            }
        }
    }


    public void Insert(String[] input) {
        try {
            int key = Integer.parseInt(input[1]);
            String value = input[2];
            this.addKey(key, value);
            worker.printStarLine();
            worker.wasSuccessful();
            return;
        } catch (Exception e) {
            worker.invalidInput();
        }
    }

    public void Search(String[] input) {
        try {
            int key = Integer.parseInt(input[1]);
            this.find(key);
        } catch (Exception e) {
            worker.invalidInput();
        }
    }

    private void find(int key) {
        ArrayList<DoubleSet> list = new ArrayList<>();
        for (DoubleSet s : hashTable.get(hash1(key))) {
            if (s != null && s.key == key) {
                list.add(s);
            }
        }
        for (DoubleSet s : list) {
            System.out.print(Colors.ANSI_BLUE + s.value + " ");
        }
        Colors.Reset();
        System.out.println();
    }

    public void show() {
        worker.printStarLine();
        while (true) {
            System.out.println("1. first level\n2. second level\n3. both\n4. quit");
            switch (worker.nextLine()) {
                case "1" -> showFirstLevel();
                case "2" -> showSecondLevel();
                case "3" -> showBothLevel();
                case "4" -> {
                    return;
                }
                default -> worker.invalidInput();
            }
        }
    }

    public String showBothLevelHelper() {
        String result = "";
        result += showFirstLevelHelper();
        result += showSecondLevelHelper();
        return result;
    }

    public void showBothLevel() {
        System.out.println(showBothLevelHelper());
    }

    public String showSecondLevelHelper() {
        String secondLevel = "";
        secondLevel += "Second level" + "\n";
        for (int i = 0; i < hashTable.size(); i++) {
            if (hasSecondaryLevel(hashTable.get(i))) {
                secondLevel += "Index " + i + ":[";
                for (int j = 1; j < hashTable.get(i).size(); j++) {
                    if (hashTable.get(i).get(j) != null) {
                        secondLevel += hashTable.get(i).get(j) + ",";
                    }
                }
                secondLevel += "]" + "\n";
            }
        }
        return secondLevel;
    }

    private boolean hasSecondaryLevel(ArrayList<DoubleSet> secondaryHashTable) {
            for (int j = 1; j < secondaryHashTable.size(); j++) {
                if (secondaryHashTable.get(j) != null) {
                    return true;
                }
            }
        return false;
    }

    public String showFirstLevelHelper() {
        String firstLevel = "";
        firstLevel += "First level" + "\n";
        for (int i = 0; i < hashTable.size(); i++) {
            firstLevel += "Index " + i + ":[";
            if (hashTable.get(i).get(0) != null) {
                firstLevel += hashTable.get(i).get(0);
            }
            firstLevel += "]" + "\n";
        }
        return firstLevel;
    }

    public void showSecondLevel() {
        System.out.println(showSecondLevelHelper());
    }

    public void showFirstLevel() {
        System.out.println(showFirstLevelHelper());
    }

    public void Deleteboth(String[] input) {
        try {
            boolean b1 = DeleteFirstTable(input);
            boolean b2 = DeleteSecondaryTable(input);
            if (!(b1 || b2)) {
                System.out.println(Colors.ANSI_RED + "Not found");
            }
        } catch (Exception e) {
            worker.invalidInput();
        }

    }

    public boolean DeleteFirstTable(String[] input) {
        try {
            int key = Integer.parseInt(input[1]);
            if (hashTable.get(hash1(key)).get(0) != null && hashTable.get(hash1(key)).get(0).key == key) {
                hashTable.get(hash1(key)).set(0, null);
                worker.wasSuccessful();
                return true;
            }
            return false;
        } catch (Exception e) {
            worker.invalidInput();
        }
        return false;
    }

    public boolean DeleteSecondaryTable(String[] input) {
        try {
            boolean check = false;
            int key = Integer.parseInt(input[1]);
            ArrayList<DoubleSet> thisListHash = hashTable.get(hash1(key));
            for (int j = 1; j < thisListHash.size(); j++) {
                if (thisListHash.get(j) != null && thisListHash.get(j).key == key) {
                    thisListHash.set(j, null);
                    check = true;
                }
            }
            if (check) {
                worker.wasSuccessful();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            worker.invalidInput();
        }
        return false;
    }
}
