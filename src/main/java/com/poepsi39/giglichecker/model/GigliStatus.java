package com.poepsi39.giglichecker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class GigliStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GigliStatus)) return false;
        GigliStatus that = (GigliStatus) o;
        return status == that.status &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, status);
    }

    @Override
    public String toString() {
        return "GigliStatus{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }


    public static final class GigliStatusBuilder {
        private Long id;
        private boolean status;

        private GigliStatusBuilder() {
        }

        public static GigliStatusBuilder aGigliStatus() {
            return new GigliStatusBuilder();
        }

        public GigliStatusBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public GigliStatusBuilder status(boolean status) {
            this.status = status;
            return this;
        }

        public GigliStatus build() {
            GigliStatus gigliStatus = new GigliStatus();
            gigliStatus.setId(id);
            gigliStatus.setStatus(status);
            return gigliStatus;
        }
    }
}
