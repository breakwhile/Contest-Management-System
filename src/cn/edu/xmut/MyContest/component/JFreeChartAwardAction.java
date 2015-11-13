package cn.edu.xmut.MyContest.component;

import java.awt.Font;
import java.awt.RenderingHints;

import cn.edu.xmut.MyContest.model.Awards;
import cn.edu.xmut.MyContest.service.QueryService;
import com.opensymphony.xwork2.ActionSupport;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

//获奖成绩报表
public class JFreeChartAwardAction extends ActionSupport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private QueryService queryService;
	// 供ChartResult调用->ActionInvocation.getStack().findValue("chart")
	private JFreeChart chart;

	public String execute() throws Exception {
		int first = queryService.count_someEntity(Awards.class, "level", "一等奖");
		int second = queryService.count_someEntity(Awards.class, "level", "二等奖");
		int third = queryService.count_someEntity(Awards.class, "level", "三等奖");
		int excellence = queryService.count_someEntity(Awards.class, "level", "优秀奖");
		int total = first + second + third + excellence;
		double per_1 = (double) first / total;
		double per_2 = (double) second / total;
		double per_3 = (double) third / total;
		double per_4 = (double) excellence / total;

		@SuppressWarnings("serial")
		StandardChartTheme theme = new StandardChartTheme("unicode") {
			public void apply(JFreeChart chart) {
				chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
				super.apply(chart);
			}
		};
		theme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 25));
		theme.setLargeFont(new Font("宋体", Font.PLAIN, 19));
		theme.setRegularFont(new Font("宋体", Font.PLAIN, 17));
		theme.setSmallFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(theme);			
		
		// 设置数据
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("一等奖", per_1);
		data.setValue("二等奖", per_2);
		data.setValue("三等奖", per_3);
		data.setValue("优秀奖", per_4);
		// 生成JFreeChart对象
		chart = ChartFactory.createPieChart("获奖成绩情况", data, true, true,
				false);

		return SUCCESS;
	}
	
	public QueryService getQueryService() {
		return queryService;
	}

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}
	
	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
}