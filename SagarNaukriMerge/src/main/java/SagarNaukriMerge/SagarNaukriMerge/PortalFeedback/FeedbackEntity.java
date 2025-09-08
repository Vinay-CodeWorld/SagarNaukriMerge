package SagarNaukriMerge.SagarNaukriMerge.PortalFeedback;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.processing.Pattern;

@Entity
@Table(name="feedback")
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//            @GeneratedValue(strategy = G)
    int id;
    String name;
    String email;
    String words;

    public FeedbackEntity(int id, String name, String email, String words) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.words = words;
    }

    public FeedbackEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
