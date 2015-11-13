package cn.edu.xmut.MyContest.component;

import java.awt.Font;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.StandardChartTheme;
import cn.edu.xmut.MyContest.model.Awards;
import cn.edu.xmut.MyContest.model.Events;
import cn.edu.xmut.MyContest.service.QueryService;
import com.opensymphony.xwork2.ActionSupport;

//获奖赛事级别报表
public class JFreeChartScopeAction extends ActionSupport implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private QueryService queryService;
	// 供ChartResult调用->ActionInvocation.getStack().findValue("chart")
	private JFreeChart chart;
	private int s1;
	private int s2;
	private int s3;
	private int s4;

	public String execute() throws Exception {
		handle_data();
		int total = s1 + s2 + s3 + s4;
		double per_1 = (double) s1 / total;
		double per_2 = (double) s2 / total;
		double per_3 = (double) s3 / total;
		double per_4 = (double) s4 / total;
		
		// 设置数据
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("校级", per_1);
		data.setValue("市级", per_2);
		data.setValue("省级", per_3);
		data.setValue("国家级", per_4);
		
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
		// 生成JFreeChart对象
		chart = ChartFactory.createPieChart("获奖赛事级别情况", data, true, true,
				false);

		return SUCCESS;
	}
	
	public void handle_data() {
		List<Object> list = (ArrayList<Object>) queryService.queryList(Awards.class);
		for (Object obj : list) {
			Awards award = (Awards) obj;
			count(award.getEventid());
		}
		
	}
	
	public void count(int id) {
		String scope = ((Events) queryService.querySingle(Events.class, id)).getScope();
		if (scope.equals("校级"))
			s1++;
		else if (scope.equals("市级"))
			s2++;
		else if (scope.equals("省级"))
			s3++;		
		else
			s4++;
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
