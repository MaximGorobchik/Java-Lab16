import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;

public class NoteBook extends JFrame {
    private JPanel btnPanel = new JPanel();
    private JButton openButton = new JButton("Відкрити"); private JButton saveButton = new JButton("Зберігти");
    private JButton clearButton = new JButton("Очистити");

    private JPanel ContentPanel = new JPanel(); private JPanel footer = new JPanel();
    private JTextArea textArea = new JTextArea();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JButton newNote = new JButton("Перевірити данні"); private JButton deleteNote = new JButton("Видалити запис");
    private JLabel NumberOfRecords = new JLabel("Кількість");
    private JTextField NumberOfRecordsField = new JTextField();
    JPanel MainPanel = new JPanel(); JPanel PrivatePanel = new JPanel(); JPanel NotePanel = new JPanel();
    private JLabel LastName = new JLabel("Прізвище*"); private JLabel FirstName = new JLabel("Ім'я*"); private JLabel Surname = new JLabel("По батькові*");
    private JLabel Nick = new JLabel("Відображати як*"); private JLabel Nickname = new JLabel("Псевдонім");
    private JTextField LastNameField = new JTextField(); private JTextField FirstNameField = new JTextField(); private JTextField SurnameField = new JTextField();
    private JTextField NickField = new JTextField(); private JTextField NicknameField = new JTextField();
    private JLabel EmailLabel = new JLabel("E-mail адрес(и)*"); private JTextArea EmailArea = new JTextArea();
    private JLabel SiteLabel = new JLabel("Особиста www-сторінка*"); private JTextField SiteField = new JTextField();
    private JLabel SexLabel = new JLabel("Стать - чоловіча(ч), жіночий(ж), не вказано(н)*"); private JTextField SexField = new JTextField();

    private JLabel BirthdayLabel = new JLabel("Дата народження"); private JTextField BirthdayField = new JTextField();
    private JLabel TelephoneLabel = new JLabel("Телефон*"); private JTextField TelephoneField = new JTextField();
    private JLabel FaxLabel = new JLabel("Факс*"); private JTextField FaxField = new JTextField();
    private JLabel TelephoneNumberLabel = new JLabel("Мобільний*"); private JTextField TelephoneNumberField = new JTextField();
    private JLabel AdressLabel = new JLabel("Дім, вулиця*"); private JTextArea AdressArea = new JTextArea();
    private JLabel TownLabel = new JLabel("Місто*"); private JTextField TownField = new JTextField();
    private JLabel RegionLabel = new JLabel("Штат/Область*"); private JTextField RegionField = new JTextField();
    private JLabel ZIPLabel = new JLabel("ZIP/Почтовий індекс*"); private JTextField ZIPField = new JTextField();
    private JLabel CountryLabel = new JLabel("Країна*"); private JTextField CountryField = new JTextField();
    private JTextArea NoteArea = new JTextArea();
    int count = 0; PersonDataBase currentPerson = new PersonDataBase();
    public NoteBook()
    {
        setSize(760,560); setLocationRelativeTo(null); setResizable(false); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnPanel.setLayout(new FlowLayout()); ContentPanel.setLayout(null); ContentPanel.setBackground(Color.lightGray);
        btnPanel.add(openButton); btnPanel.add(saveButton);
        btnPanel.setBackground(Color.lightGray);
        add(btnPanel, BorderLayout.NORTH);
        SetContentPanelWest(); SetContentPanelEast(); setFooter();
        add(ContentPanel, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
        newNote.addActionListener(new NewNoteActionListener());
        deleteNote.addActionListener(new DeleteNoteActionListener());
        openButton.addActionListener(new OpenBtnActionListener());
        saveButton.addActionListener(new SaveBtnActionListener());
        clearButton.addActionListener(new ClearBtnActionListener());
        NumberOfRecordsField.setText("0");
        setVisible(true);
    }
    void SetContentPanelWest()
    {
        textArea.setBounds(5,20,300,350);
        textArea.setLineWrap(true); textArea.setEditable(false);
        ContentPanel.add(textArea);
        newNote.setBounds(15,380,135,30);
        deleteNote.setBounds(155,380,130,30);
        clearButton.setBounds(88, 415,110,30);
        ContentPanel.add(newNote); ContentPanel.add(deleteNote); ContentPanel.add(clearButton);
    }
    void SetContentPanelEast()
    {
        tabbedPane.setBounds(310,15,430,400);
        tabbedPane.add("Основне", MainPanel); tabbedPane.add("Особисте", PrivatePanel); tabbedPane.add("Замітки", NotePanel);
        ContentPanel.add(tabbedPane);
        SetMainPanel(); SetPrivatePanel(); SetNotePanel();
    }
    void SetMainPanel()
    {
        MainPanel.setLayout(null);
        MainPanel.add(LastName); MainPanel.add(LastNameField); MainPanel.add(FirstName); MainPanel.add(FirstNameField);
        MainPanel.add(Surname); MainPanel.add(SurnameField); MainPanel.add(Nick); MainPanel.add(NickField);
        MainPanel.add(Nickname); MainPanel.add(NicknameField);

        LastName.setBounds(50,10,95,50); FirstName.setBounds(50,45,95,50);
        Surname.setBounds(50,80,95,50); Nick.setBounds(50,115,105,50);
        Nickname.setBounds(50,150,95,50);
        LastNameField.setBounds(165, 26, 200,20); FirstNameField.setBounds(165, 61, 200,20);
        SurnameField.setBounds(165, 96, 200,20); NickField.setBounds(165, 131, 200,20);
        NicknameField.setBounds(165, 166, 200,20);

        MainPanel.add(EmailLabel); MainPanel.add(EmailArea);
        EmailLabel.setBounds(20,186,95,50); EmailArea.setBounds(20,225,400,70); EmailArea.setBackground(Color.lightGray);
        MainPanel.add(SiteLabel); MainPanel.add(SiteField); EmailArea.setLineWrap(true);
        SiteLabel.setBounds(20,290,150,50); SiteField.setBounds(180,305,200,20);
        MainPanel.add(SexLabel); MainPanel.add(SexField);
        SexLabel.setBounds(50,320,270,50); SexField.setBounds(330,335,20,20); SexField.setHorizontalAlignment(JTextField.RIGHT);
    }
    void SetPrivatePanel()
    {
        PrivatePanel.setLayout(null);

        PrivatePanel.add(BirthdayLabel); PrivatePanel.add(BirthdayField); PrivatePanel.add(TelephoneLabel); PrivatePanel.add(TelephoneField);
        PrivatePanel.add(FaxLabel); PrivatePanel.add(FaxField); PrivatePanel.add(TelephoneNumberLabel); PrivatePanel.add(TelephoneNumberField);

        BirthdayLabel.setBounds(50,10,105,50); TelephoneLabel.setBounds(50,45,105,50);
        FaxLabel.setBounds(50,80,105,50); TelephoneNumberLabel.setBounds(50,115,105,50);
        BirthdayField.setBounds(165, 26, 200,20); TelephoneField.setBounds(165, 61, 200,20);
        FaxField.setBounds(165, 96, 200,20); TelephoneNumberField.setBounds(165, 131, 200,20);

        PrivatePanel.add(AdressLabel); PrivatePanel.add(AdressArea);
        AdressLabel.setBounds(20,156,75,50); AdressArea.setBounds(20,195,400,40); AdressArea.setBackground(Color.lightGray);
        AdressArea.setLineWrap(true);

        PrivatePanel.add(TownLabel); PrivatePanel.add(TownField); PrivatePanel.add(RegionLabel); PrivatePanel.add(RegionField);
        PrivatePanel.add(ZIPLabel); PrivatePanel.add(ZIPField); PrivatePanel.add(CountryLabel); PrivatePanel.add(CountryField);

        TownLabel.setBounds(60,230,100,50); RegionLabel.setBounds(60,260,100,50);
        ZIPLabel.setBounds(60,295,125,50); CountryLabel.setBounds(60,330,100,50);
        TownField.setBounds(180,245,200,20); RegionField.setBounds(180,275,200,20);
        ZIPField.setBounds(200,310,170,20); CountryField.setBounds(180,345,200,20);
    }
    void SetNotePanel()
    {
        NotePanel.setLayout(null);
        NotePanel.add(NoteArea); NoteArea.setLineWrap(true);
        NoteArea.setBounds(20,10,380,200); NoteArea.setBackground(Color.lightGray);
    }
    void setFooter() {
        footer.setPreferredSize(new Dimension(0, 35));
        footer.setBackground(Color.lightGray);
        footer.add(NumberOfRecords);
        footer.add(NumberOfRecordsField);
        NumberOfRecords.setFont(new Font("Arial", Font.BOLD, 15));
        NumberOfRecordsField.setPreferredSize(new Dimension(70, 20));
        NumberOfRecordsField.setEnabled(false);
    }
    class NewNoteActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
            if(LastNameField.getText().equals("") || FirstNameField.getText().equals("") || SurnameField.getText().equals("")
            || NickField.getText().equals("") || EmailArea.getText().equals("") || SiteField.getText().equals("")
                    || TelephoneField.getText().equals("") || TelephoneNumberField.getText().equals("")
            || FaxField.getText().equals("") || AdressArea.getText().equals("") || TownField.getText().equals("") || RegionField.getText().equals("")
            || ZIPField.getText().equals("") || CountryField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Веддіть всі обов'язкові данні", "", JOptionPane.ERROR_MESSAGE);
            }
            else {
                textArea.setFont(new Font("Arial", Font.BOLD, 15));
                textArea.append(LastName.getText() + " - " + LastNameField.getText() + "\n");
                textArea.append(FirstName.getText() + " - " + FirstNameField.getText() + "\n");
                textArea.append(Surname.getText() + " - " + SurnameField.getText() + "\n");
                textArea.append(Nick.getText() + " - " + NickField.getText() + "\n");
                if(NicknameField.getText().equals(""))
                {
                    textArea.append(Nickname.getText() + " - " + "не вказано" + "\n");
                }
                else
                {
                    textArea.append(Nickname.getText() + " - " + NicknameField.getText() + "\n");
                }
                textArea.append(EmailLabel.getText() + " - " + EmailArea.getText() + "\n");
                textArea.append(SiteLabel.getText() + " - " + SiteField.getText() + "\n");
                if(SexField.getText().equalsIgnoreCase("ч") || SexField.getText().equalsIgnoreCase("ж") ||
                SexField.getText().equalsIgnoreCase("н"))
                {
                    textArea.append("Стать" + " - " + SexField.getText() + "\n");
                }
                else
                {
                    textArea.append("Стать" + " - " + "не вказано" + "\n");
                }
                if(BirthdayField.getText().equals(""))
                {
                    textArea.append(BirthdayLabel.getText() + " - " + "не вказано" + "\n");
                }
                else
                {
                    textArea.append(BirthdayLabel.getText() + " - " + BirthdayField.getText() + "\n");
                }
                textArea.append(TelephoneLabel.getText() + " - " + TelephoneField.getText() + "\n");
                textArea.append(FaxLabel.getText() + " - " + FaxField.getText() + "\n");
                textArea.append(TelephoneNumberLabel.getText() + " - " + TelephoneNumberField.getText() + "\n");
                textArea.append(AdressLabel.getText() + " - " + AdressArea.getText() + "\n");
                textArea.append(TownLabel.getText() + " - " + TownField.getText() + "\n");
                textArea.append(RegionLabel.getText() + " - " + RegionField.getText() + "\n");
                textArea.append(ZIPLabel.getText() + " - " + ZIPField.getText() + "\n");
                textArea.append(CountryLabel.getText() + " - " + CountryField.getText() + "\n");
                if(!NoteArea.getText().equals("")) {
                    textArea.append("Замітки:" + "\n" + NoteArea.getText());
                }
            }
        }
    }
    class ClearBtnActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                LastNameField.setText("");
                FirstNameField.setText("");
                SurnameField.setText("");
                NickField.setText("");
                NicknameField.setText("");
                EmailArea.setText("");
                SiteField.setText("");
                SexField.setText("");
                BirthdayField.setText("");
                TelephoneField.setText("");
                FaxField.setText("");
                TelephoneNumberField.setText("");
                AdressArea.setText("");
                TownField.setText("");
                RegionField.setText("");
                ZIPField.setText("");
                CountryField.setText("");
                NoteArea.setText("");
                JOptionPane.showMessageDialog(null, "Очищено!" , "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    class DeleteNoteActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (count == 0) {
                JOptionPane.showMessageDialog(null, "Немає записів!", "", JOptionPane.ERROR_MESSAGE);
            } else {
                String msg = "Оберіть запис, який хочете видалити\n";
                for(int i = 0; i < count; i++)
                {
                    msg += (i+1) + ". " + "Запис " + (i+1) + "\n";
                }
                int value = 1;
                try {
                    String option = JOptionPane.showInputDialog(msg);
                    value = Integer.parseInt(option);
                }
                catch (NumberFormatException err)
                {
                    JOptionPane.showMessageDialog(null, "Введіть число!", "", JOptionPane.ERROR_MESSAGE);
                }
                boolean check = value >= 1 && value <= count;
                if(!check)
                {
                    JOptionPane.showMessageDialog(null, "Немає такого запису!", "", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    File FileToDelete = new File("person" + value);
                    boolean deleted = FileToDelete.delete();
                    if (deleted) {
                        JOptionPane.showMessageDialog(null, "Видалено", "", JOptionPane.INFORMATION_MESSAGE);
                        count--;
                    }
                }
                NumberOfRecordsField.setText(Integer.toString(count));
            }
        }
    }
    class SaveBtnActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(LastNameField.getText().equals("") || FirstNameField.getText().equals("") || SurnameField.getText().equals("")
            || NickField.getText().equals("") || EmailArea.getText().equals("") || SiteField.getText().equals("")
            || TelephoneField.getText().equals("") || FaxField.getText().equals("") || TelephoneNumberField.getText().equals("")
            || AdressArea.getText().equals("") || TownField.getText().equals("") || RegionField.getText().equals("")
            || ZIPField.getText().equals("") || CountryField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Заповніть всі данні!", "", JOptionPane.ERROR_MESSAGE);
            }
            else {
                currentPerson.SetLastNameField(LastNameField.getText());
                currentPerson.SetFirstNameField(FirstNameField.getText());
                currentPerson.SetSurNameField(SurnameField.getText());
                currentPerson.SetNickField(NickField.getText());
                if (NicknameField.getText().equals("")) {
                    currentPerson.SetNickNameField("не вказано");
                } else {
                    currentPerson.SetNickNameField(NicknameField.getText());
                }
                currentPerson.SetEmailField(EmailArea.getText());
                currentPerson.SetSiteField(SiteField.getText());
                if(SexField.getText().equals(""))
                {
                    currentPerson.SetSexField('н');
                }
                else
                {
                    currentPerson.SetSexField(SexField.getText().charAt(0));
                }
                if (BirthdayField.getText().equals("")) {
                    currentPerson.SetBirthdayField(null);
                } else {
                    LocalDate date = LocalDate.parse(BirthdayField.getText());
                    currentPerson.SetBirthdayField(date);
                }
                currentPerson.SetTelephoneField(TelephoneField.getText());
                currentPerson.SetFaxField(FaxField.getText());
                currentPerson.SetTelephoneNumberField(TelephoneNumberField.getText());
                currentPerson.SetAdressArea(AdressArea.getText());
                currentPerson.SetTownField(TownField.getText());
                currentPerson.SetRegionField(RegionField.getText());
                currentPerson.SetZIPField(ZIPField.getText());
                currentPerson.SetCountryField(CountryField.getText());
                currentPerson.SetNoteArea(NoteArea.getText());

                try {
                    FileWriter fileWriter = new FileWriter("person" + (count+1));
                    fileWriter.write(
                            LastName.getText() + " - " + currentPerson.GetLastNameField() + "\n"+
                            FirstName.getText() + " - " + currentPerson.GetFirstNameField() + "\n"+
                            Surname.getText() + " - " + currentPerson.GetSurNameField() + "\n"+
                                    Nick.getText() + " - " + currentPerson.GetNickField() + "\n"+
                            Nickname.getText() + " - " + currentPerson.GetNickNameField() + "\n" +
                                    EmailLabel.getText() + " - " + currentPerson.GetEmailField() + "\n"+
                    SiteLabel.getText() + " - " + currentPerson.GetSiteField() + "\n"+
                                    "Стать" + " - " + currentPerson.GetSexField() + "\n"+
                    BirthdayLabel.getText() + " - " + currentPerson.GetBirthdayField() + "\n"+
                                    TelephoneLabel.getText() + " - " + currentPerson.GetTelephoneField() + "\n"+
                            FaxLabel.getText() + " - " + currentPerson.GetFaxField() + "\n"+
                                    TelephoneNumberLabel.getText() + " - " + currentPerson.GetTelephoneNumberField() + "\n"+
                            AdressLabel.getText() + " - " + currentPerson.GetAdressArea() + "\n"+
                                    TownLabel.getText() + " - " + currentPerson.GetTownField() + "\n"+
                            RegionLabel.getText() + " - " + currentPerson.GetRegionField() + "\n"+
                                    ZIPLabel.getText() + " - " + currentPerson.GetZIPField() + "\n"+
                    CountryLabel.getText() + " - " + currentPerson.GetCountryField() + "\n");
                    if(currentPerson.GetNoteArea() != null) {
                        fileWriter.append("Замітки:" + "\n" + currentPerson.GetNoteArea());
                    }
                    count++;
                    fileWriter.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null,"Збережено!", "", JOptionPane.INFORMATION_MESSAGE);
                NumberOfRecordsField.setText(Integer.toString(count));
            }
        }
    }
    class OpenBtnActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
            if(currentPerson.GetLastNameField() == null)
            {
                JOptionPane.showMessageDialog(null, "Ви нічого не зберігали!", "", JOptionPane.ERROR_MESSAGE);
            }
            else {
                if(count != 0) {
                    String msg = "Оберіть запис, який хочете відкрити\n";
                    for (int i = 0; i < count; i++) {
                        msg += (i + 1) + ". " + "Запис " + (i + 1) + "\n";
                    }
                    int value = 1;
                    try {
                        String option = JOptionPane.showInputDialog(msg);
                        value = Integer.parseInt(option);
                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(null, "Введіть число!", "", JOptionPane.ERROR_MESSAGE);
                    }
                    boolean check = value >= 1 && value <= count;
                    if (!check) {
                        JOptionPane.showMessageDialog(null, "Немає такого запису!", "", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            FileReader fileReader = new FileReader("person" + value);
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            String line;
                            StringBuilder stringBuilder = new StringBuilder();
                            while ((line = bufferedReader.readLine()) != null) {
                                stringBuilder.append(line).append("\n");
                            }
                            bufferedReader.close();
                            fileReader.close();
                            String FileContent = stringBuilder.toString();
                            textArea.setText(FileContent);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException("File not found!");
                        } catch (IOException ex) {
                            throw new RuntimeException("Error reading file!");
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Ви нічого не зберігали!", "", JOptionPane.ERROR_MESSAGE);
                }
                }
            }

        }
    }
