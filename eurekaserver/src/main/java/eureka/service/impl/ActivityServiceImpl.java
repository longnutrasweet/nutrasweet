package eureka.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl {

	@Autowired
	private TaskService taskService;

	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private HistoryService historyService;

	public void createActiviti(String instanceId) {
		runtimeService.startProcessInstanceById(instanceId);
	}

	public void deploymentProcessDefinition() {
		Deployment deploy = repositoryService.createDeployment().name("exclusiveGateWay")
				.addClasspathResource("process/gateway.bpmn").deploy();
		System.out.println("部署id: " + deploy.getId());
		System.out.println("部署name: " + deploy.getName());
	}

	public void startProcessInstance() {
		String instanceKey = "gatewayprocess";
		Map<String, Object> variableMap = new HashMap<String, Object>();

		variableMap.put("money", 1);
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(instanceKey, variableMap);

		System.out.println("流程实例id： " + pi.getId());
		System.out.println("流程实例名称: " + pi.getName());

	}

	public void queryPersonalTask(String assignee) {
		List<Task> list = taskService.createTaskQuery().taskAssignee(assignee).orderByTaskCreateTime().asc().list();

		System.out.println(list.get(0));
	}

	public void completeTask(String taskId) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("reject", "false");
		// taskService.setVariable(taskId, variableName, value);
		taskService.complete(taskId, variables);
		System.out.println(111);
	}

	public void queryTaskByTaskId(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		// taskService.getVariables(taskId);
		System.out.println();
	}

	public void queryHistory(String id) {
		List<HistoricVariableInstance> tasks = historyService.createHistoricVariableInstanceQuery()
				.processInstanceId(id).list();
		System.out.println(tasks);
	}

	public void getActivitiPicture(HttpServletRequest req, HttpServletResponse rep, String processDefinitionId)
			throws IOException {

		InputStream is = repositoryService.getProcessDiagram(processDefinitionId);

		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = is.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		byte[] in2b = swapStream.toByteArray();

		rep.getOutputStream().write(in2b);
	}

}
