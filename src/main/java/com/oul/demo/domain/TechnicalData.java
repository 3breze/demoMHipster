package com.oul.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "technical_data")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TechnicalData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "stream_url")
    private String streamUrl;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "video_duration")
    private String videoDuration;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_size")
    private long fileSize;

    @Column(name = "is_public")
    private boolean isPublic;

    @Column(name = "resolution")
    private String resolution;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "technicalData")
    @JsonManagedReference
    private List<ContentData> contentDataList;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false, updatable = true)
    @JsonBackReference
    private Company company;

}
