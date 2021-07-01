package com.launchacademy;

import com.launchacademy.League;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/positions", "/"})
public class LeagueController extends HttpServlet {

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    League league =  League.getLeague();
    List<Team> teams = league.getTeams();
    String requestedTeamIndex = req.getParameter("teamIndex");
    String requestedPosition = req.getParameter("name");

    if (req.getServletPath().equals("/positions")) {
      Set<String> positionsKey = league.getPlayersPerPosition().keySet();

      List<String> positions = new ArrayList<>(positionsKey);

      req.setAttribute("positions", positions);
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/teams/position.jsp");
      dispatcher.forward(req,resp);
    } else if (req.getServletPath().equals("/")){
      req.setAttribute("teams", league.getTeams());
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/teams/index.jsp");
      dispatcher.forward(req, resp);
    }

    if (requestedTeamIndex != null) {
      int index = Integer.parseInt(requestedTeamIndex);
      if (index >=0 && index <teams.size()) {
        Team team = teams.get(index);
        req.setAttribute("team", team);
        List<Player> players = team.getPlayers();
        req.setAttribute("players", players);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/teams/show.jsp");
        dispatcher.forward(req,resp);
      } else {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND);

      }
    }

    if (requestedPosition != null) {
      List<Player> playersPerPosition = League.getLeague().getPlayersPerPosition().get(requestedPosition);
      Map<Player, String> match = League.getLeague().getPlayersPerTeam();

      req.setAttribute("name", requestedPosition);
      req.setAttribute("playersList", playersPerPosition);
      req.setAttribute("matchTeamName", match);

      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/teams/positionShow.jsp");
      dispatcher.forward(req,resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    League league =  League.getLeague();
    List<Team> teams = league.getTeams();
    String requestedTeamIndex = req.getParameter("teamIndex");
    int index = Integer.parseInt(requestedTeamIndex);
    if(index <= 0 || index > teams.size()) {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }
}
