package com.example.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.valuerange.CountableValueRange;
import org.optaplanner.core.api.domain.valuerange.ValueRangeFactory;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Task {

    @PlanningId
    private Integer id;

    private String artColorDegree;

    @PlanningVariable(valueRangeProviderRefs = {"planDateIdRange"})
    private Integer planDateId;
    @PlanningVariable(valueRangeProviderRefs = {"machineGroupIdRange"})
    private Integer machineGroupId;

    public Integer getProduceType() {
        if (planDateId != null && planDateId != 0 && machineGroupId != null && machineGroupId != 0) {
            return 1;
        } else {
            return 2;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtColorDegree() {
        return artColorDegree;
    }

    public void setArtColorDegree(String artColorDegree) {
        this.artColorDegree = artColorDegree;
    }

    public Integer getPlanDateId() {
        return planDateId;
    }

    public void setPlanDateId(Integer planDateId) {
        this.planDateId = planDateId;
    }

    public Integer getMachineGroupId() {
        return machineGroupId;
    }

    public void setMachineGroupId(Integer machineGroupId) {
        this.machineGroupId = machineGroupId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", produceType=" + getProduceType() +
                ", planDateId=" + planDateId +
                ", machineGroupId=" + machineGroupId +
                '}';
    }
}
