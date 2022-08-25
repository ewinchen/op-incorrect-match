package com.example.service;

import com.example.domain.Solution;
import com.example.domain.Task;
import org.optaplanner.core.api.score.ScoreExplanation;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.SolverConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

@Service
public class AppService {

    private static final Logger logger = LoggerFactory.getLogger(AppService.class);


    public Map<String, Object> solve() {
        InputStream is = AppService.class.getResourceAsStream("/com/example/solverConfig.xml");
        SolverConfig solverConfig = SolverConfig.createFromXmlInputStream(Objects.requireNonNull(is));
        SolverFactory<Solution> solverFactory = SolverFactory.create(solverConfig);
        Solver<Solution> solver = solverFactory.buildSolver();

        Solution unsolved = new Solution();

        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task();
        task1.setId(1);
        task1.setArtColorDegree("Dark");
        taskList.add(task1);

        Task task2 = new Task();
        task2.setId(2);
        task2.setArtColorDegree("Light");
        taskList.add(task2);

        Task task3 = new Task();
        task3.setId(3);
        task3.setArtColorDegree("White");
        taskList.add(task3);

        List<Integer> planDateList = Arrays.asList(0,1,2,3,4,5,6,7,8);

        List<Integer> machineGroupList = Arrays.asList(0,1,2,3,4,5,6,7,8);

        unsolved.setTaskList(taskList);
        unsolved.setPlanDataList(planDateList);
        unsolved.setMachineGroupList(machineGroupList);

        Solution solved = solver.solve(unsolved);

        ScoreManager<Solution, HardMediumSoftScore> scoreManager = ScoreManager.create(solverFactory);
        ScoreExplanation<Solution, HardMediumSoftScore> scoreExplanation = scoreManager.explainScore(solved);
        logger.info(scoreExplanation.getSummary());

        Map<String, Object> result = new HashMap<>();
        result.put("solved", solved);
        return result;

    }

}
