package entity;

import javax.persistence.*;

@Entity
public class Iscrizione {
	@EmbeddedId
	private IscrizionePk iscrizionePk;
}
