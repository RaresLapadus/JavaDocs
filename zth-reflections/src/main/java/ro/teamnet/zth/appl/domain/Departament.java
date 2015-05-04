package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by rares on 4/28/2015.
 */
@Table(name ="departments")
public class Departament {
    @Id(name = "DEPARTAMENT_ID")
    private Integer id;
    @Column(name = "DEPARTAMENT_NAME")
    private String departmentName;
    @Column(name = "LOCATION_ID")
    private Integer location;
}
