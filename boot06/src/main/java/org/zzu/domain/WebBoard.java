package org.zzu.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name ="tbl_webboards")
@EqualsAndHashCode(of ="bno")
@ToString
public class WebBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	private String content;
	private String writer;
	
	@CreationTimestamp
	private Timestamp regate;
	@UpdateTimestamp
	private Timestamp updatedate;
	
}
