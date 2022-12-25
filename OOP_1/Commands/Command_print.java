import java.util.Scanner;

import Lesson4.FamilyTreeUtils;
import Lesson4.Interfaces.ICommand;

/**
 * Вывод дерева на экран
 */
public class Command_print implements ICommand {

    @Override
    public String info() {
        return "print - вывод дерева";
    }

    @Override
    public String getName() {
        return "print";
    }

    @Override
    public void execute(Scanner scanner, FamilyTreeUtils utils) {
        utils.print();
    }
}
Footer
