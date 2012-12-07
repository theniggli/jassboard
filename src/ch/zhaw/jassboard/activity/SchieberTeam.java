package ch.zhaw.jassboard.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchieberTeam
  implements Serializable
{
  private static final long serialVersionUID = -242805805128712436L;
  private int current_state = 0;
  private List<SchieberScore> states = new ArrayList();
  private int total_states = 0;

  public SchieberTeam()
  {
    this.states.add(this.current_state, new SchieberScore());
  }

  private SchieberScore add_scores(SchieberScore paramSchieberScore1, SchieberScore paramSchieberScore2)
  {
    return new SchieberScore(paramSchieberScore1.score + paramSchieberScore2.score, paramSchieberScore1.count_20 + paramSchieberScore2.count_20, paramSchieberScore1.count_50 + paramSchieberScore2.count_50, paramSchieberScore1.count_100 + paramSchieberScore2.count_100, paramSchieberScore1.add_score + paramSchieberScore2.add_score);
  }

  private SchieberScore split_score(int paramInt)
  {
    SchieberScore localSchieberScore = new SchieberScore();
    localSchieberScore.score = paramInt;
    if (paramInt < 100)
      label19: if (paramInt >= 50)
    while (true)
    {
      if (paramInt < 20)
      {
        localSchieberScore.add_score = paramInt;
        paramInt -= 100;
        localSchieberScore.count_100 = (1 + localSchieberScore.count_100);
        label54: paramInt -= 50;
        localSchieberScore.count_50 = (1 + localSchieberScore.count_50);
      }
      paramInt -= 20;
      localSchieberScore.count_20 = (1 + localSchieberScore.count_20);
    }
      return localSchieberScore;
  }

  private SchieberScore split_score(int paramInt1, int paramInt2)
  {
    return split_score(paramInt1 + paramInt2);
  }

  public void add_score(int paramInt)
  {
    int i = ((SchieberScore)this.states.get(this.current_state)).add_score;
    int j = this.current_state;
    ((SchieberScore)this.states.get(this.current_state)).add_score = 0;
    SchieberScore localSchieberScore1 = (SchieberScore)this.states.get(this.current_state);
    localSchieberScore1.score -= i;
    this.total_states = (1 + this.total_states);
    this.current_state = (1 + this.current_state);
    this.states.add(this.current_state, add_scores(split_score(paramInt, i), (SchieberScore)this.states.get(-1 + this.current_state)));
    if (this.total_states > this.current_state)
      this.total_states = this.current_state;
    ((SchieberScore)this.states.get(j)).add_score = i;
    SchieberScore localSchieberScore2 = (SchieberScore)this.states.get(j);
    localSchieberScore2.score = (i + localSchieberScore2.score);
  }

  public int get_100()
  {
    return ((SchieberScore)this.states.get(this.current_state)).count_100;
  }

  public int get_20()
  {
    return ((SchieberScore)this.states.get(this.current_state)).count_20;
  }

  public int get_50()
  {
    return ((SchieberScore)this.states.get(this.current_state)).count_50;
  }

  public int get_additional()
  {
    return ((SchieberScore)this.states.get(this.current_state)).add_score;
  }

  public int get_total()
  {
    return ((SchieberScore)this.states.get(this.current_state)).score;
  }

  public void realignScore(int paramInt1, int paramInt2)
  {
    int i = get_20();
    if (i <= paramInt1);
    while (true)
    {
      if (get_50() <= paramInt2)
      {
        SchieberScore localSchieberScore1 = (SchieberScore)this.states.get(this.current_state);
        localSchieberScore1.count_20 = (-5 + localSchieberScore1.count_20);
        SchieberScore localSchieberScore2 = (SchieberScore)this.states.get(this.current_state);
        localSchieberScore2.count_100 = (1 + localSchieberScore2.count_100);
        i = get_20();
        break;
      }
      SchieberScore localSchieberScore3 = (SchieberScore)this.states.get(this.current_state);
      localSchieberScore3.count_50 = (-2 + localSchieberScore3.count_50);
      SchieberScore localSchieberScore4 = (SchieberScore)this.states.get(this.current_state);
      localSchieberScore4.count_100 = (1 + localSchieberScore4.count_100);
    }
  }

  public void redo()
  {
    if (this.current_state < this.total_states)
      this.current_state = (1 + this.current_state);
  }

  public void set_score(int paramInt)
  {
    if (paramInt == get_total())
    {
      this.total_states = (1 + this.total_states);
      this.current_state = (1 + this.current_state);
      this.states.add(this.current_state, (SchieberScore)this.states.get(-1 + this.current_state));
    }
    while (true)
    {
      if (this.total_states > this.current_state)
        this.total_states = this.current_state;
      this.total_states = (1 + this.total_states);
      this.current_state = (1 + this.current_state);
      this.states.add(this.current_state, split_score(paramInt));
    }
  }

  public void shortenList(int paramInt)
  {
    if (this.total_states >= paramInt)
    {
      List localList = this.states.subList(1 + (this.total_states - paramInt), 1 + this.total_states);
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(localList);
      this.states.clear();
      this.states.addAll(localArrayList);
      this.current_state -= 1 + this.total_states - paramInt;
      this.total_states -= 1 + this.total_states - paramInt;
    }
  }

  public void undo()
  {
    if (this.current_state > 0)
      this.current_state = (-1 + this.current_state);
  }
}