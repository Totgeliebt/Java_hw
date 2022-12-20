import java.util.Scanner;

import Lesson2.FamilyTreeUtils;


public interface ICommand {
    /**
     * Информация о команде
     * @return
     */
    String info();

    /**
     * код команды при вводе с клавиатуры
     * @return
     */
    String getName();

    /**
     * Выполняемый метод
     * @param scanner
     * @param utils
     */
    void execute(Scanner scanner, FamilyTreeUtils utils);
}