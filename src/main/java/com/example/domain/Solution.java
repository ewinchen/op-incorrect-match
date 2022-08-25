package com.example.domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;

import java.util.List;


@PlanningSolution
public class Solution {

    @PlanningEntityCollectionProperty
    private List<Task> taskList;

    @ValueRangeProvider(id = "planDateIdRange")
    @ProblemFactCollectionProperty
    private List<Integer> planDataList;

    @ValueRangeProvider(id = "machineGroupIdRange")
    @ProblemFactCollectionProperty
    private List<Integer> machineGroupList;

    @PlanningScore
    private HardMediumSoftScore score;


    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public HardMediumSoftScore getScore() {
        return score;
    }

    public void setScore(HardMediumSoftScore score) {
        this.score = score;
    }

    public List<Integer> getPlanDataList() {
        return planDataList;
    }

    public void setPlanDataList(List<Integer> planDataList) {
        this.planDataList = planDataList;
    }

    public List<Integer> getMachineGroupList() {
        return machineGroupList;
    }

    public void setMachineGroupList(List<Integer> machineGroupList) {
        this.machineGroupList = machineGroupList;
    }
}
	

