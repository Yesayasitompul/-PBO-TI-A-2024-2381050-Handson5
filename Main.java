import java.util.Scanner;

public class Main {
    public static String[] todos = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        todos[0] = " Membaca";
        todos[1] = " Menulis";
        todos[2] = " Menggambar";
        showTodoList();
        removeTodoList(-1);
        System.out.println("After Delete");
        showTodoList();
    }

    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            if (todos[i] != null) {
                System.out.println((i + 1) + ". " + todo);
            }
        }
    }

    public static void addTodoList() {
        resizeArrayIfFull();
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                String todo = todos[i];
                todos[i] = todo;
                break;
            }
        }
    }

    private static void resizeArrayIfFull() {
        boolean isFull = isArrayFull();
        if (isFull) {
            resizeArrayToTwoTimesBigger();
        }
    }

    private static void resizeArrayToTwoTimesBigger() {
        String[] temp = todos;
        todos = new String[todos.length * 2];
        for (int i = 0; i < temp.length; i++) {
            todos[i] = temp[i];
        }
    }

    private static boolean isArrayFull() {
        boolean isFull = true;
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public static boolean removeTodoList(Integer number) {
        if (number <= 0) {
            return false;
        }
        if (number - 1 < todos.length - 1) {
            return false;
        }
        if (todos[number - 1] == null) {
            return false;
        }
        for (int i = number - 1; i < todos.length; i++) {
            //if todo is the last element
            if (i == (todos.length - 1)) {
                todos[i] = null;
            } else {
                //replace with the element on the right
                todos[i] = todos[i + 1];
            }
        }
        return true;
    }

    public static void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showTodoList();
            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Edit");
            System.out.println("4. Keluar");
            String selectedMenu = scanner.nextLine();
            switch (selectedMenu) {
                case "1":
                    System.out.println("Menu add todo list");
                    break;

                case "2":
                    System.out.println("Menu remove todo list");
                    break;

                case "3":
                    System.out.println("Menu Edit todo list");
                    break;

                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih Menu Dengan Benar");
            }
        }
    }

    public static String input(String info) {
        System.out.println(info + " : ");
        String data = Scanner.nextline();
        return data;
    }

    public static void showMenuAddTodoList() {
        System.out.println("MENAMBAH TODO LIST");
        String todo = input("Todo (x jika batal");
        if (todo.equals("x")) {
        } else {
            addTodoList(todo);
        }
    }

    public static void showMenuRemoveTodoList() {
        System.out.println("MENGHAPUS TODO LIST");
        String todoYangDipilih = input("Nomor todo yang dihapus (x jika batal)");
        if(todoYangDipilih.equals("x")) {

        } else {
            boolean success = removeTodoList(Integer.valueOf(todoYangDipilih));
            if (!success) {
                System.out.println("Gagal mengahapus todo list : " + todoYangDipilih);
            }
        }
    }

    public static void showMenuEditTodoList() {
        System.out.println("MENGEDIT TODO LIST");
        String selectedTodo = input("Masukkan nomor todo (x jika batal)");
        if (selectedTodo.equals("x")) {
            return;
        }
        String newTodo = input("Masukkan todo yang baru (x jika batal");
        if (newTodo.equals("x")) {
            return;
        }
        boolean isEditTodoSuccess = showMenuEditTodoList( Integer.valueOf(selectedTodo), newTodo);
        if (isEditTodoSuccess) {
            System.out.println("Berhasil Mengedit todo");
        } else {
            System.out.println("Gagal Mengedit todo");
        }
    }
}