package com.launchacademy.admin.models;

import com.launchacademy.rsvp.models.Participant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "events")
public class Event {
  @Id
  @SequenceGenerator(name = "event_generator",sequenceName = "events_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @NotBlank
  @Column(name = "title", nullable = false)
  private String title;

  @NotBlank
  @Column(name = "street", nullable = false)
  private String street;

  @NotBlank
  @Column(name = "city", nullable = false)
  private String city;

  @NotBlank
  @Column(name = "state", nullable = false)
  private String state;

  @Column(name = "postal_code", nullable = false)
  private String postalCode;

  @OneToMany(mappedBy = "event")
  private List<Participant> participantList = new ArrayList<>();

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStreet() {
    return this.street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPostalCode() {
    return this.postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public List<Participant> getParticipantList() {
    return this.participantList;
  }

  public void setParticipantList(List<Participant> participantList) {
    this.participantList = participantList;
  }
}
