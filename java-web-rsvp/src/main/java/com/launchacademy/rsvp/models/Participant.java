package com.launchacademy.rsvp.models;

import com.launchacademy.admin.models.Event;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "participants")
public class Participant {
  @Id
  @SequenceGenerator(name = "participant_generator", sequenceName = "participants_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participant_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @NotBlank
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotBlank
  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Email
  @Column(name = "email", nullable = false)
  private String email;

  @NotBlank
  @Column(name = "phone", nullable = false)
  private String phone;

  @NotBlank
  @Column(name = "contact_type", nullable = false)
  private String contactType;

  @Column(name = "event_id", nullable = false, insertable = false, updatable = false)
  private int eventId;

  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event event;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getContactType() {
    return this.contactType;
  }

  public void setContactType(String contactType) {
    this.contactType = contactType;
  }

  public int getEventId() {
    return this.eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  public Event getEvent() {
    return this.event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }
}
