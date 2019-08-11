package com.zim.chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.zim.cmn.ChartHandler;

import com.zim.cmn.StringUtil;

@WebServlet(description = "윤구차트", urlPatterns = { "/chart/chart.json" })
public class ChartController extends HttpServlet implements ChartHandler {
	private static final long serialVersionUID = 1L;

	private ChartService chartservice;

	public ChartController() {
		super();
		chartservice = new ChartService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("doGet");
		doServiceHandler(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.debug("doPost");
		doServiceHandler(request, response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zim.cmn.ChartHandler#doServiceHandler(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doServiceHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("02 doServiceHandler()");
		request.setCharacterEncoding("UTF-8");

		String workDiv = StringUtil.nvl(request.getParameter("login_div"), "");
		LOG.debug("02.1 workDiv:" + workDiv);

		switch (workDiv) {

		case "do_pro_chart":
			do_pro_chart(request, response);
			break;

		}

	}

	@Override
	public void do_pro_chart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("03 do_pie_chart");
		ChartVO inVO = new ChartVO();
		List<ChartVO> list = (List<ChartVO>) chartservice.do_pro_chart(inVO);
		LOG.debug("03.1 list:" + list);
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String gsonString = "";

		// JSON:Jsonarray [[],[],[],[],[],[]]

		JsonArray jArray = new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			JsonArray sArray = new JsonArray();
			sArray.add(list.get(i).getLabel());
			sArray.add(list.get(i).getData());

			jArray.add(sArray);
		}
		gsonString = jArray.toString();
		LOG.debug("03.2 gsonString:" + gsonString);
		out.print(gsonString);

	}



}
