package com.example.myserials.Domain;
import com.example.myserials.R;

/**
 * Created by abataloff on 20.10.13.
 */
public class SeasonAndSeriesNumber implements ISeriesNumber {

    static final int FIRST_SEASON = 1;
    static final int FIRST_SERIES = 1;

    int[] seriesMap;
    int seasonNumber;
    int seriesNumber;

    public void setSeriesNumber(int a_seriesNumber) {
        this.seriesNumber = a_seriesNumber;
    }

    public void setSeasonNumber(int a_seasonNumber) {
        this.seasonNumber = a_seasonNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getSeriesNumber() {
        return seriesNumber;
    }

    public SeasonAndSeriesNumber(int[] a_seriesMap,int a_seasonNumber, int a_seriesNumber) {
        seriesMap = a_seriesMap;
        seasonNumber = a_seasonNumber;
        seriesNumber = a_seriesNumber;
    }

    public SeriesNumeration getSeriesNumeration()
    {
       return SeriesNumeration.SeasonAndSeries;
    }

    public void  Inc()
    {
        IncSeries();
    }

    public void IncSeries()
    {
        // Если есть данные по текущему сезону
        if(seasonNumber <= seriesMap.length-1)
        {
            int _lastSeries=seriesMap[seasonNumber];
            // и если в этом сезоне текущая серия не последняя
            if(seriesNumber < _lastSeries)
            {
                // увеличиваем серию
                seriesNumber++;
            }
            // иначе, если серия посденяя
            else if(seriesNumber == _lastSeries)
                 {
                    // увеличиваем сезон
                    IncSeason();
                 }
                else
                {
                    // не должно быть для сезона по которму есть данные
                    throw new RuntimeException("Выполнение недопустимого кода");
                }
        }
        else
        {
            // иначе просто увеличиваем серию
            seriesNumber++;
        }
    }

    public void IncSeason()
    {
        seasonNumber++;
        seriesNumber = FIRST_SERIES;
    }

    @Override
    public String toString()
    {
        // TODO: Найти пример использования String.format(String format, String[] args);
        //return String.format("Сезон {0} Серия {1}",getSeasonNumber(),getSeriesNumber());

        // TODO: Реализовать с получение строки из context
//        return R.string.season_string + " " + Integer.toString(getSeasonNumber()) + " " +
//               R.string.series_string + " " + Integer.toString(getSeriesNumber());

        return "Сезон " + Integer.toString(getSeasonNumber()) + " " +
               "Серия " + Integer.toString(getSeriesNumber());
    }
}
