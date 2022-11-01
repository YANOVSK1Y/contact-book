package main.contactbook;
import java.util.ArrayList;

public class Contact {
    private String _contactName;
    private ContactInfo _contactPhone;

    private ContactInfo email1 = null;
    private ContactInfo email2 = null;
    private ContactInfo email3 = null;

    private Social social1 = null;
    private Social social2 = null;
    private Social social3 = null;
    private Social social4 = null;
    private Social social5 = null;


    private class NameContactInfo implements ContactInfo{
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return _contactName;
        }
        @Override
        public String toString(){
            return "Name: " + _contactName;
        }
    }

    public static class Email implements ContactInfo{
        private final String _localPart;
        private final String _domain;
        private final String _email;
        public Email(String localPart, String domain){
            _localPart = localPart;
            _domain = domain;
            _email = localPart + "@" + domain;
        }
        @Override
        public String getTitle() {
            return "Email";
        }
        @Override
        public String getValue() {
            return _email;
        }
        @Override
        public String toString(){
            return "Email: " + _email;
        }
    }
    public static class Social implements ContactInfo {
        private String _socialId;
        private String _title;
        public Social(String socialTitle, String SocialId){
            _socialId = SocialId;
            _title = socialTitle;
        }
        public void setTitle(String title){
            _title = title;
        }
        @Override
        public String getTitle() {
            return _title;
        }

        @Override
        public String getValue() {
            return _socialId;
        }
        @Override
        public String toString(){
            return _title + ": " + _socialId;
        }
    }

    public Contact(String contactName) {
        if (contactName == null || contactName.equals("")) throw new IllegalArgumentException();
        _contactName = contactName;
    }

    public void rename(String newName) {
        if (newName != null && !newName.equals("")) _contactName = newName;
    }

    public Email addEmail(String localPart, String domain) {
        Email em = new Email(localPart, domain);
        if (email1 == null) {
            email1 = em;
            return em;
        }
        else if (email2 == null) {
            email2 = em;
            return em;
        }
        else if (email3 == null) {
            email3 = em;
            return em;
        }
        else return null;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        Email em = new Email(firstname, lastname){
            @Override
            public String getTitle() {
                return "Epam Email";
            }
            @Override
            public String getValue() {
                return firstname +"_" + lastname+ "@epam.com";
            }
            @Override
            public String toString(){
                return "Epam Email: " + firstname +"_" + lastname+ "@epam.com";
            }

        };
        if (email1 == null) {
            email1 = em;
            return em;
        }
        else if (email2 == null) {
            email2 = em;
            return em;
        }
        else if (email3 == null) {
            email3 = em;
            return em;
        }
        else return null;
    }
    public ContactInfo addPhoneNumber(int code, String number) {
        ContactInfo ph = new ContactInfo(){
            @Override
            public String getTitle() {
                return "Tel";
            }
            @Override
            public String getValue(){
                return "+" + code + " " + number;
            }
            @Override
            public String toString(){
                return "Tel: +" + code + " " + number;
            }
        };
        if (_contactPhone == null) {
            _contactPhone = ph;
            return ph;
        }
         else return null;
    }
    public Social addTwitter(String twitterId) {
        Social tw = new Social("Twitter", twitterId);
        if (social1 == null) {
            social1 = tw;
            return tw;
        }
        else if (social2 == null) {
            social2 = tw;
            return tw;
        }
        else if (social3 == null) {
            social3 = tw;
            return tw;
        }
        else if (social4 == null) {
            social4 = tw;
            return tw;
        }
        else if (social5 == null) {
            social5 = tw;
            return tw;
        }
        else return null;
    }

    public Social addInstagram(String instagramId) {
        Social inst = new Social("Instagram", instagramId);
        if (social1 == null) {
            social1 = inst;
            return inst;
        }
        else if (social2 == null) {
            social2 = inst;
            return inst;
        }
        else if (social3 == null) {
            social3 = inst;
            return inst;
        }
        else if (social4 == null) {
            social4 = inst;
            return inst;
        }
        else if (social5 == null) {
            social5 = inst;
            return inst;
        }
        else return null;
    }

    public Social addSocialMedia(String title, String id) {
        Social sMedia = new Social(title, id);
        if (social1 == null) {
            social1 = sMedia;
            return sMedia;
        }
        else if (social2 == null) {
            social2 = sMedia;
            return sMedia;
        }
        else if (social3 == null) {
            social3 = sMedia;
            return sMedia;
        }
        else if (social4 == null) {
            social4 = sMedia;
            return sMedia;
        }
        else if (social5 == null) {
            social5 = sMedia;
            return sMedia;
        }
        else return null;
    }

    public ContactInfo[] getInfo() {
        ContactInfo name = new ContactInfo(){
            @Override
            public String getTitle() {
                return "Name";
            }

            @Override
            public String getValue() {
                return _contactName;
            }
            @Override
            public String toString(){
                return "Name: " + _contactName;
            }
        };

        int counter = 0;
        if (name != null) counter++;
        if (_contactPhone != null) counter++;
        if (email1 != null) counter++;
        if (email2 != null) counter++;
        if (email3 != null) counter++;
        if (social1 != null) counter++;
        if (social2 != null) counter++;
        if (social3 != null) counter++;
        if (social4 != null) counter++;
        if (social5 != null) counter++;

        ContactInfo[] res = new ContactInfo[counter];

        int i = 0;

        if (name.getValue() != null) {res[i] = name; i++;}
        if (_contactPhone != null) {res[i] = _contactPhone; i++;}
        if (email1 != null) {res[i] = email1; i++;}
        if (email2 != null) {res[i] = email2; i++;}
        if (email3 != null) {res[i] = email3; i++;}
        if (social1 != null) {res[i] = social1; i++;}
        if (social2 != null) {res[i] = social2; i++;}
        if (social3 != null) {res[i] = social3; i++;}
        if (social4 != null) {res[i] = social4; i++;}
        if (social5 != null) {res[i] = social5; i++;}

        return res;
    }

}
