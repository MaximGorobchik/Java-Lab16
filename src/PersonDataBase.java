import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class PersonDataBase implements Comparable, Serializable {
    private String LastNameField = null; private String FirstNameField = null;
    private String SurnameField = null; private String NickField = null;
    private String NicknameField = null; private String EmailField = null; private String SiteField = null;
    private char SexField = 'н'; private LocalDate BirthdayField = null;
    private String TelephoneField = null; private String FaxField = null;
    private String TelephoneNumberField = null; private String AdressArea = null;
    private String TownField = null; private String RegionField = null;
    private String ZIPField = null; private String CountryField = null;
    private String NoteArea = null;

    //////////////////////////////////////////////////////////////////
    public String GetLastNameField()
    {
        return this.LastNameField;
    }
    public String GetFirstNameField()
    {
        return this.FirstNameField;
    }
    public String GetSurNameField()
    {
        return this.SurnameField;
    }
    public String GetNickField()
    {
        return this.NickField;
    }
    public String GetNickNameField()
    {
        return this.NicknameField;
    }
    public String GetEmailField()
    {
        return this.EmailField;
    }
    public String GetSiteField()
    {
        return this.SiteField;
    }
    public char GetSexField()
    {
        return this.SexField;
    }
    public LocalDate GetBirthdayField()
    {
        return this.BirthdayField;
    }
    public String GetTelephoneField()
    {
        return this.TelephoneField;
    }
    public String GetFaxField()
    {
        return this.FaxField;
    }
    public String GetTelephoneNumberField()
    {
        return this.TelephoneNumberField;
    }
    public String GetAdressArea()
    {
        return this.AdressArea;
    }
    public String GetTownField()
    {
        return this.TownField;
    }
    public String GetRegionField()
    {
        return this.RegionField;
    }
    public String GetZIPField()
    {
        return this.ZIPField;
    }
    public String GetCountryField()
    {
        return this.CountryField;
    }
    public String GetNoteArea()
    {
        return this.NoteArea;
    }
    ///////////////////////////////////////////////////

    public void SetLastNameField(String l)
    {
        this.LastNameField = l;
    }
    public void SetFirstNameField(String f)
    {
        this.FirstNameField = f;
    }
    public void SetSurNameField(String s)
    {
        this.SurnameField = s;
    }
    public void SetNickField(String n)
    {
        this.NickField = n;
    }
    public void SetNickNameField(String n)
    {
        this.NicknameField = n;
    }
    public void SetEmailField(String e)
    {
        this.EmailField = e;
    }
    public void SetSiteField(String s)
    {
        this.SiteField = s;
    }
    public void SetSexField(char s)
    {
        this.SexField = s;
    }
    public void SetBirthdayField(LocalDate b)
    {
        this.BirthdayField = b;
    }
    public void SetTelephoneField(String t)
    {
        this.TelephoneField = t;
    }
    public void SetFaxField(String f)
    {
        this.FaxField = f;
    }
    public void SetTelephoneNumberField(String t)
    {
        this.TelephoneNumberField = t;
    }
    public void SetAdressArea(String a)
    {
        this.AdressArea = a;
    }
    public void SetTownField(String t)
    {
        this.TownField = t;
    }
    public void SetRegionField(String r)
    {
        this.RegionField = r;
    }
    public void SetZIPField(String z)
    {
        this.ZIPField = z;
    }
    public void SetCountryField(String c)
    {
        this.CountryField = c;
    }
    public void SetNoteArea(String n)
    {
        this.NoteArea = n;
    }
    public PersonDataBase() {
    }
    @Override
    public int compareTo (Object o){
        return NickField.compareTo(((PersonDataBase) o).NickField);
    }
    public String toString ()
    {
        return (NickField == null ? "---?---" : NickField);
    }
}
