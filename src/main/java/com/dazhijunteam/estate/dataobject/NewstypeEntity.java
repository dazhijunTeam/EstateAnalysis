package com.dazhijunteam.estate.dataobject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "newstype", schema = "EstateAnalysis", catalog = "")
public class NewstypeEntity {
    private String newstypeId;
    private String newstypeName;

    @Id
    @Column(name = "newstype_id", nullable = false, length = 30)
    public String getNewstypeId() {
        return newstypeId;
    }

    public void setNewstypeId(String newstypeId) {
        this.newstypeId = newstypeId;
    }

    @Basic
    @Column(name = "newstype_name", nullable = true, length = 50)
    public String getNewstypeName() {
        return newstypeName;
    }

    public void setNewstypeName(String newstypeName) {
        this.newstypeName = newstypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewstypeEntity that = (NewstypeEntity) o;
        return Objects.equals(newstypeId, that.newstypeId) &&
                Objects.equals(newstypeName, that.newstypeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(newstypeId, newstypeName);
    }
}
