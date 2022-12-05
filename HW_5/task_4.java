public class Solution {

    public static void main(String[] args) {
        List<QueenBoard> solutions = new NQueensProblem(8).getAllSolutions();
        for(QueenBoard board : solutions) {
            System.out.println(board.toString());
        }
    }

}

class NQueensProblem {

    private int size;

    private List<QueenBoard> solutions;

    public NQueensProblem(int size) {
        this.size = size;
        this.solutions = new LinkedList<QueenBoard>();
        solve(size);
    }

    public void solve(int size) {
        QueenBoard board = new QueenBoard(size);
        LogicalBoard logicalBoard = new LogicalBoard(size);
        solve(board, logicalBoard, 0, size);
    }

    public List<QueenBoard> getAllSolutions() {
        return solutions;
    }

    private void solve(QueenBoard board, LogicalBoard logicalBoard,
            int rowNumber, int size) {
        if (rowNumber == size) {
            solutions.add(board);
            return;
        }
        for (int column = 0; column < size; column++) {
            if (logicalBoard.getPossible(rowNumber, column)) {
                QueenBoard newBoard = new QueenBoard(board);
                newBoard.setHasQueen(rowNumber, column, true);
                LogicalBoard newLogicalBoard = new LogicalBoard(logicalBoard);
                newLogicalBoard.setPossible(rowNumber, column, false);
                updateBoard(rowNumber, column, newLogicalBoard, size);
                solve(newBoard, newLogicalBoard, rowNumber + 1, size);
            }
        }
    }

    private void updateBoard(int row, int col, LogicalBoard logicalBoard, int size) {
        updateRow(row, logicalBoard, size);
        updateColumn(col, logicalBoard, size);
        updateDiagonal(row, col, -1, -1, logicalBoard, size);
        updateDiagonal(row, col, 1, 1, logicalBoard, size);
        updateDiagonal(row, col, 1, -1, logicalBoard, size);
        updateDiagonal(row, col, -1, 1, logicalBoard, size);
    }

    private void updateRow(int row, LogicalBoard logicalBoard, int size) {
        for (int j = 0; j < size; j++) {
            logicalBoard.setPossible(row, j, false);
        }
    }

    private void updateColumn(int col, LogicalBoard logicalBoard, int size) {
        for (int j = 0; j < size; j++) {
            logicalBoard.setPossible(j, col, false);
        }
    }

    private void updateDiagonal(int row, int rowIncrement, int col, int colIncrement, LogicalBoard logicalBoard, int size) {
        while (row >= 0 && col < 8) {
            logicalBoard.setPossible(row, col, false);
            row += rowIncrement;
            col += colIncrement;
        }
    }

}

class QueenBoard {

    private boolean[][] board;
    int size;

    public QueenBoard(int size) {
        this.size = size;
        this.board = new boolean[size][size];
    }

    public QueenBoard(QueenBoard oldBoard) {
        this.size = oldBoard.size;
        this.board = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                this.board[i][j] = oldBoard.board[i][j];
            }
        }
    }

    public void setHasQueen(int x, int y, boolean value) {
        board[x][y] = value;
    }

    public boolean hasQueen(int x, int y) {
        return board[x][y];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("------------------------------\n");
        for (int i = 0; i < size; i++) {
            result.append("|");
            for (int j = 0; j < size; j++) {
                result.append((board[i][j] ? "Q" : " ") + "|");
            }
            result.append("\n");
        }
        result.append("------------------------------");
        return result.toString();
    }

}

class LogicalBoard {

    private boolean[][] board;
    int size;

    public LogicalBoard(int size) {
        this.size = size;
        board = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                this.board[i][j] = true;
            }
        }
    }

    public LogicalBoard(LogicalBoard oldBoard) {
        this.size = oldBoard.size;
        this.board = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                this.board[i][j] = oldBoard.board[i][j];
            }
        }
    }

    public void setPossible(int x, int y, boolean value) {
        board[x][y] = value;
    }

    public boolean getPossible(int x, int y) {
        return board[x][y];
    }

}
