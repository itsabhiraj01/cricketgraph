library(RMySQL)
library(dbConnect)
#create connection
con=dbConnect(MySQL(),user="root",password="",dbname="hadoop",host="localhost")

#get resultset from databse
cricket_args = fetch(dbSendQuery(con,"SELECT * FROM cricketargs;"))
first = cricket_args$first
format = cricket_args$format
year = cricket_args$year
#fetch(dbSendQuery(con,"DELETE FROM cricketargs;"))
if(first == "All") {
  if(format == "All") {
    if(year == 0) {
      last_id = fetch(dbSendQuery(con,"SELECT score,year FROM cricket;"))
    } else {
      last_id = fetch(dbSendQuery(con,paste("SELECT score,year FROM cricket  where year=",as.integer(year),";",sep="")))
    }
  } else {
    if(year == 0) {
      last_id = fetch(dbSendQuery(con,paste("SELECT score,year FROM cricket where format='",format,"';",sep="")))
    } else {
      last_id = fetch(dbSendQuery(con,paste("SELECT score,year FROM cricket  where format='",format,"' AND year=",as.integer(year),";",sep="")))
    }
  }
} else {
  if(format == "All") {
    if(year == 0) {
      last_id = fetch(dbSendQuery(con,paste("SELECT score,year FROM cricket where first='",first,"';",sep="")))
    } else {
      last_id = fetch(dbSendQuery(con,paste("SELECT score,year FROM cricket  where first='",firsr,"' AND year=",year,";",sep="")))
    }
  } else {
    if(year == 0) {
      last_id = fetch(dbSendQuery(con,paste("SELECT score,year FROM cricket where first='",first,"' AND format='",format,"';",sep="")))
    } else {
      last_id = fetch(dbSendQuery(con,paste("SELECT score,year FROM cricket  where first = '",first,"' AND format='",format,"' AND year=",year," ;",sep = "")))
    }
  }
}
#get resultset from databse
#last_id = fetch(dbSendQuery(con,"SELECT score,year FROM cricket  where name='dhoni' AND format='odi';"))

#create vecot list of runs
runs <- c()
for(i in last_id$score) {
  runs <- c(runs,i)
  print(i)
}

#create vector list of years
years <- c()
for(i in last_id$year) {
  years <- c(years,as.character(i))
  print(i)
}

#set colors
colors = c("green","red","orange","brown")

#give the chart file a name
png(file = "barchart.png")
#png(file = "barchart.png",width=3.25,height = 3.25,units = "in", res = 1200)

# Plot the bar chart
barplot(runs, 
        main = paste("Graph of runs of",first), 
        xlab = "years" , 
        ylab = "runs",
        #xlim = c(0,100),
        ylim = c(0,200),
        names.arg = years,
        cex.names = 1,
        #col=colors,
        col = rainbow(20),
        space = 1,
        width = 10,
        border = "black"
        )
#if(chart.hasRendered())
#  chart.export

# Save the file
dev.off()

runs
year