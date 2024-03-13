package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client implements Comparable<Client> {

    private String name;
    private Date log;

    public Client() {
    }
    public Client(String name, Date log) {
        this.name = name;
        this.log = log;
    }

    public Date getLog() {
        return log;
    }
    public String getName() {
        return name;
    }

    public void setLog(Date log) {
        this.log = log;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + log.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        Client other  = (Client) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) return false;
        return true;
    }

    @Override
    public int compareTo(Client o) {
        return name.compareTo(o.name);
    }
}