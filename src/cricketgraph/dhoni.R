library(RMySQL)
library(dbConnect)
#create connection
con=dbConnect(MySQL(),user="root",password="",dbname="hadoop",host="localhost")

#get resultset from databse
last_id = fetch(dbSendQuery(con,"SELECT score,year FROM cricket  where name='dhoni' AND format='odi';"))

#create vecot list of runs
runs <- c()
for(i in last_id$score) {
  runs <- c(runs,i)
  print(i)
}

#create vector list of years
year <- c()
for(i in last_id$year) {
  year <- c(year,as.character(i))
  print(i)
}

#set colors
colors = c("green","red","orange","brown")

#give the chart file a name
png(file = "barchart.png")
#png(file = "barchart.png",width=3.25,height = 3.25,units = "in", res = 1200)

# Plot the bar chart
barplot(runs, 
        main = "Score", 
        xlab = "years" , 
        ylab = "runs",
        xlim = c(0,200),
 #       breaks = 20,
        names.arg = year, 
        col=colors, 
        border = "black")
#if(chart.hasRendered())
#  chart.export

# Save the file
dev.off()
