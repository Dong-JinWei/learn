package com.dowei.librarysys.view;

import com.dowei.librarysys.dao.AuthorDao;
import com.dowei.librarysys.dao.BookDao;
import com.dowei.librarysys.dao.TypeDao;
import com.dowei.librarysys.entity.Author;
import com.dowei.librarysys.entity.Book;
import com.dowei.librarysys.entity.BookType;
import com.dowei.librarysys.utils.MyUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BookPanel extends JPanel {
    private JPanel jPanel1, jPanel2, jPanel3;
    private JLabel jLabel;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JButton jButton1, jButton2, jButton3;
    private AddBookDialog addBookDialog;
    private UpdateBookDialog updateBookDialog;

    public BookPanel() {
        updateBookDialog = new UpdateBookDialog();
        addBookDialog = new AddBookDialog();
        this.setLayout(new BorderLayout());
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jLabel = new JLabel("图书管理");
        jButton1 = new JButton("增加图书");
        jButton2 = new JButton("删除图书");
        jButton3 = new JButton("修改图书");
        BookPanelClick bookPanelClick = new BookPanelClick();
        jButton1.addActionListener(bookPanelClick);
        jButton2.addActionListener(bookPanelClick);
        jButton3.addActionListener(bookPanelClick);
        jTable = new JTable(new BookTableModel());
        jScrollPane = new JScrollPane(jTable);
        jPanel1.add(jLabel);
        jPanel2.add(jScrollPane);
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);
        jPanel3.add(jButton3);
        this.add(jPanel1, BorderLayout.NORTH);
        this.add(jPanel2, BorderLayout.CENTER);
        this.add(jPanel3, BorderLayout.SOUTH);
    }

    private class BookPanelClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButton1) {
                System.out.println("增加图书");
                addBookDialog.setVisible(true);
            } else if (e.getSource() == jButton2) {
                System.out.println("删除图书");
                int[] rowNum = jTable.getSelectedRows();
                if (rowNum.length <= 0) {
                    JOptionPane.showMessageDialog(jPanel2, "请至少选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                BookTableModel bookTableModel = new BookTableModel();
                Vector<Vector<String>> rowData = bookTableModel.getRowData();
                BookDao bookDao = new BookDao();
                int choose = JOptionPane.showConfirmDialog(jPanel2, "确认是否删除");
                if (choose != 0) {
                    return;
                }
                for (int row : rowNum) {
                    int effect = bookDao.delBook(Integer.parseInt(rowData.get(row).get(0)));
                    if (effect <= 0) {
                        JOptionPane.showMessageDialog(jPanel2, "删除失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(jPanel2, "删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                jTable.setModel(new BookTableModel());
            } else if (e.getSource() == jButton3) {
                System.out.println("修改图书");
                int rowNum = jTable.getSelectedRow();
                if (rowNum < 0) {
                    JOptionPane.showMessageDialog(jPanel2, "请至少选择一行", "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                BookTableModel bookTableModel = new BookTableModel();

                Vector<Vector<String>> rowData = bookTableModel.getRowData();
                Vector<String> oneRow = rowData.get(rowNum);
                BookDao bookDao = new BookDao();
                Book oneBook = bookDao.getOneBook(Integer.parseInt(oneRow.get(0)));
                updateBookDialog.showDialog(oneBook);

            }
        }
    }

    public class AddBookDialog extends JDialog {

        private JPanel jPanelTitle;
        private JPanel jPanelAuthor;
        private JPanel jPanelIBSN;
        private JPanel jPanelType;
        private JPanel jPanelButton;

        private JLabel jLabelTitle;
        private JLabel jLabelAuthor;
        private JLabel jLabelIBSN;
        private JLabel jLabelType;

        private JTextField jTextFieldTitle;
        private JTextField jTextFieldAuthor;
        private JTextField jTextFieldIBSN;
        private JTextField jTextFieldType;

        private JButton jButtonEnter;
        private JButton jButtonReset;

        public AddBookDialog() {
            this.setLayout(new GridLayout(5, 1));
            jPanelTitle = new JPanel();
            jPanelAuthor = new JPanel();
            jPanelIBSN = new JPanel();
            jPanelType = new JPanel();
            jPanelButton = new JPanel();

            jLabelTitle = new JLabel("书籍名字");
            jLabelAuthor = new JLabel("作者名");
            jLabelIBSN = new JLabel("IBSN");
            jLabelType = new JLabel("类型名");

            jTextFieldTitle = new JTextField(20);
            jTextFieldAuthor = new JTextField(20);
            jTextFieldIBSN = new JTextField(20);
            jTextFieldType = new JTextField(20);

            jButtonEnter = new JButton("增加书籍");
            jButtonReset = new JButton("重置数据");
            AddBookDialogClick addBookDialogClick = new AddBookDialogClick();
            jButtonReset.addActionListener(addBookDialogClick);
            jButtonEnter.addActionListener(addBookDialogClick);

            jPanelTitle.add(jLabelTitle);
            jPanelTitle.add(jTextFieldTitle);
            jPanelAuthor.add(jLabelAuthor);
            jPanelAuthor.add(jTextFieldAuthor);
            jPanelIBSN.add(jLabelIBSN);
            jPanelIBSN.add(jTextFieldIBSN);
            jPanelType.add(jLabelType);
            jPanelType.add(jTextFieldType);
            jPanelButton.add(jButtonEnter);
            jPanelButton.add(jButtonReset);

            this.add(jPanelTitle);
            this.add(jPanelAuthor);
            this.add(jPanelIBSN);
            this.add(jPanelType);
            this.add(jPanelButton);

            this.setTitle("增加书籍");
            this.setSize(400, 500);
            this.setLocationRelativeTo(null);
            this.setModal(true);
        }

        public void clear() {
            jTextFieldTitle.setText("");
            jTextFieldAuthor.setText("");
            jTextFieldIBSN.setText("");
            jTextFieldType.setText("");
        }

        public class AddBookDialogClick implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButtonEnter) {
//                    System.out.println("确认修改");
                    String bookTitle = jTextFieldTitle.getText();
                    if (bookTitle.length() < 1 || bookTitle.length() > 20) {
                        JOptionPane.showMessageDialog(jPanel2, "书名必须再1到20个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    String bookAuthor = jTextFieldAuthor.getText();
                    if (bookAuthor.length() < 1 || bookAuthor.length() > 20) {
                        JOptionPane.showMessageDialog(jPanel2, "作者名必须再1到20个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    AuthorDao authorDao = new AuthorDao();
                    if (!authorDao.isAuthorExist(bookAuthor)) {
                        authorDao.addAuthor(new Author(null, bookAuthor));
                    }
                    String bookISBNStr = jTextFieldIBSN.getText();
                    if (bookISBNStr.length() < 1 || bookISBNStr.length() > 20) {
                        JOptionPane.showMessageDialog(jPanel2, "ISBN必须再1到20个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (!MyUtils.isInt(bookISBNStr)) {
                        JOptionPane.showMessageDialog(jPanel2, "ISBN必须是一个整数", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int bookISBN = Integer.parseInt(bookISBNStr);
                    BookDao bookDao = new BookDao();
                    if (bookDao.isISBNExist(bookISBN)) {
                        JOptionPane.showMessageDialog(jPanel2, "次ISBN已经存在", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String bookTypeName = jTextFieldType.getText();
                    if (bookTypeName.length() < 1 || bookTypeName.length() > 8) {
                        JOptionPane.showMessageDialog(jPanel2, "类型名必须再1到8个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    TypeDao typeDao = new TypeDao();
                    if (!typeDao.isTypeExistByTypeName(bookTypeName)) {
                        typeDao.addType(new BookType(null, bookTypeName));
                    }
                    Author author = authorDao.getAuthorByName(bookAuthor);
                    BookType oneTypeByName = typeDao.getOneTypeByName(bookTypeName);
                    int effect = bookDao.addBook(new Book(null, bookTitle, new Author(author.getAuthorId(), bookAuthor), bookISBN, new BookType(oneTypeByName.getTypeId(), bookTypeName)));
                    if (effect < 0) {
                        JOptionPane.showMessageDialog(jPanel2, "增加失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(jPanel2, "增加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    jTable.setModel(new BookTableModel());
                    addBookDialog.setVisible(false);
                    clear();
                } else if (e.getSource() == jButtonReset) {
                    System.out.println("重置数据");
                    clear();
                }
            }
        }

    }

    public class UpdateBookDialog extends JDialog {

        private JPanel jPanelTitle;
        private JPanel jPanelAuthor;
        private JPanel jPanelIBSN;
        private JPanel jPanelType;
        private JPanel jPanelButton;

        private JLabel jLabelTitle;
        private JLabel jLabelAuthor;
        private JLabel jLabelIBSN;
        private JLabel jLabelType;

        private JTextField jTextFieldTitle;
        private JTextField jTextFieldAuthor;
        private JTextField jTextFieldIBSN;
        private JTextField jTextFieldType;

        private JButton jButtonEnter;
        private JButton jButtonReset;

        private Book book;

        public UpdateBookDialog() {
            this.setLayout(new GridLayout(5, 1));
            jPanelTitle = new JPanel();
            jPanelAuthor = new JPanel();
            jPanelIBSN = new JPanel();
            jPanelType = new JPanel();
            jPanelButton = new JPanel();

            jLabelTitle = new JLabel("书籍名字");
            jLabelAuthor = new JLabel("作者名");
            jLabelIBSN = new JLabel("IBSN");
            jLabelType = new JLabel("类型名");

            jTextFieldTitle = new JTextField(20);
            jTextFieldAuthor = new JTextField(20);
            jTextFieldIBSN = new JTextField(20);
            jTextFieldType = new JTextField(20);

            jButtonEnter = new JButton("修改书籍");
            jButtonReset = new JButton("重置数据");
            UpdateBookDialogClick updateBookDialogClick = new UpdateBookDialogClick();
            jButtonReset.addActionListener(updateBookDialogClick);
            jButtonEnter.addActionListener(updateBookDialogClick);

            jPanelTitle.add(jLabelTitle);
            jPanelTitle.add(jTextFieldTitle);
            jPanelAuthor.add(jLabelAuthor);
            jPanelAuthor.add(jTextFieldAuthor);
            jPanelIBSN.add(jLabelIBSN);
            jPanelIBSN.add(jTextFieldIBSN);
            jPanelType.add(jLabelType);
            jPanelType.add(jTextFieldType);
            jPanelButton.add(jButtonEnter);
            jPanelButton.add(jButtonReset);

            this.add(jPanelTitle);
            this.add(jPanelAuthor);
            this.add(jPanelIBSN);
            this.add(jPanelType);
            this.add(jPanelButton);

            this.setTitle("增加书籍");
            this.setSize(400, 500);
            this.setLocationRelativeTo(null);
            this.setModal(true);
        }

        public void clear() {
            jTextFieldTitle.setText(book.getBookTitle());
            jTextFieldAuthor.setText(book.getAuthor().getAuthorName());
            jTextFieldIBSN.setText(book.getBookISBN() + "");
            jTextFieldType.setText(book.getType().getTypeName());
        }

        public void showDialog(Book book) {
            this.book = book;

            this.setTitle("修改" + book.getBookTitle() + "中");
            jTextFieldTitle.setText(book.getBookTitle());
            jTextFieldAuthor.setText(book.getAuthor().getAuthorName());
            jTextFieldIBSN.setText(book.getBookISBN() + "");
            jTextFieldType.setText(book.getType().getTypeName());
            this.setVisible(true);
        }

        public class UpdateBookDialogClick implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButtonEnter) {
//                    System.out.println("确认修改");
                    String bookTitle = jTextFieldTitle.getText();
                    if (bookTitle.length() < 1 || bookTitle.length() > 20) {
                        JOptionPane.showMessageDialog(jPanel2, "书名必须再1到20个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    String bookAuthor = jTextFieldAuthor.getText();
                    if (bookAuthor.length() < 1 || bookAuthor.length() > 20) {
                        JOptionPane.showMessageDialog(jPanel2, "作者名必须再1到20个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    AuthorDao authorDao = new AuthorDao();
                    if (!authorDao.isAuthorExist(bookAuthor)) {
                        authorDao.addAuthor(new Author(null, bookAuthor));
                    }
                    String bookISBNStr = jTextFieldIBSN.getText();
                    if (bookISBNStr.length() < 1 || bookISBNStr.length() > 20) {
                        JOptionPane.showMessageDialog(jPanel2, "ISBN必须再1到20个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (!MyUtils.isInt(bookISBNStr)) {
                        JOptionPane.showMessageDialog(jPanel2, "ISBN必须是一个整数", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int bookISBN = Integer.parseInt(bookISBNStr);
                    BookDao bookDao = new BookDao();
                    if (bookDao.isISBNExist(bookISBN)) {
                        JOptionPane.showMessageDialog(jPanel2, "次ISBN已经存在", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String bookTypeName = jTextFieldType.getText();
                    if (bookTypeName.length() < 1 || bookTypeName.length() > 8) {
                        JOptionPane.showMessageDialog(jPanel2, "类型名必须再1到8个字符之间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    TypeDao typeDao = new TypeDao();
                    if (!typeDao.isTypeExistByTypeName(bookTypeName)) {
                        typeDao.addType(new BookType(null, bookTypeName));
                    }
                    Author author = authorDao.getAuthorByName(bookAuthor);
                    BookType oneTypeByName = typeDao.getOneTypeByName(bookTypeName);
                    int effect = bookDao.updateBook(new Book(book.getBookId(), bookTitle, new Author(author.getAuthorId(), bookAuthor), bookISBN, new BookType(oneTypeByName.getTypeId(), bookTypeName)));
                    if (effect < 0) {
                        JOptionPane.showMessageDialog(jPanel2, "修改失败", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(jPanel2, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    jTable.setModel(new BookTableModel());
                    updateBookDialog.setVisible(false);
                    clear();
                } else if (e.getSource() == jButtonReset) {
                    System.out.println("重置数据");
                    clear();
                }
            }
        }


    }
}
