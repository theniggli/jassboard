package ch.zhaw.jassboard.activity;

import java.io.Serializable;

public class SchieberScore
  implements Serializable
{
  private static final long serialVersionUID = 3012200037853092700L;
  public int add_score = 0;
  public int count_100 = 0;
  public int count_20 = 0;
  public int count_50 = 0;
  public int score = 0;

  public SchieberScore()
  {
  }

  public SchieberScore(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.score = paramInt1;
    this.count_20 = paramInt2;
    this.count_50 = paramInt3;
    this.count_100 = paramInt4;
    this.add_score = paramInt5;
  }
}