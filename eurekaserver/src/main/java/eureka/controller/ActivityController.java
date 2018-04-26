package eureka.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eureka.service.impl.ActivityServiceImpl;

@RestController
@RequestMapping("/activiti")
public class ActivityController {

	@Autowired
	private ActivityServiceImpl activityServiceImpl;

	@RequestMapping("/createactiviti")
	public void createActiviti(@RequestParam String instanceId) {
		activityServiceImpl.createActiviti(instanceId);
	}

	@RequestMapping("/deploymentprocessdefinition")
	public void deploymentProcessDefinition() {
		activityServiceImpl.deploymentProcessDefinition();
	}

	@RequestMapping("/startprocessinstance")
	public void startProcessInstance() {
		activityServiceImpl.startProcessInstance();
	}

	@RequestMapping("/querypersonaltask")
	public void queryPersonalTask(@RequestParam String assignee) {
		activityServiceImpl.queryPersonalTask(assignee);
	}

	@RequestMapping("/completeTask")
	public void completeTask(@RequestParam String taskId) {
		activityServiceImpl.completeTask(taskId);
	}

	@RequestMapping("/querytaskbytaskid")
	public void queryTaskByTaskId(@RequestParam String taskId) {
		activityServiceImpl.queryTaskByTaskId(taskId);
	}

	@RequestMapping("/queryhistory")
	public void queryHistory(@RequestParam String id) {
		activityServiceImpl.queryHistory(id);
		;
	}

	@RequestMapping("/getactivitipicture")
	public void getActivitiPicture(HttpServletRequest req, HttpServletResponse rep,
			@RequestParam String processDefinitionId) throws IOException {
		activityServiceImpl.getActivitiPicture(req, rep, processDefinitionId);
	}

}
