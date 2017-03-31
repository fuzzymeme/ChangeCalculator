# ChangeCalculator
Calculates all the different ways you can provide a change for a given amount with a given set for denominations. 

I was watching a video of simple programming problems (https://www.youtube.com/watch?v=qH7fVuYlOOc&t=281s) and one of the comments questioned how to calculate all combinations of change. I thought that would be a nice little project so I wrote this code. 

The code records all the answers as it goes along - which may not be required - it could just print out the new answer or record the count. 

It's a bit clunky to have the answers being added to a object level variable, but I'm OK with that for a simple program. I was more interested in the algorithm that generated the combinations. 

I didn't read the video author's note about eliminating duplicates so in a earlier version it was effectively generating duplicates (e.g. {1x5 1x10} = {1x10 1x5}) but I added an index and it removed the duplicates and it runs much faster. Then I saw "Byte By Byte"'s suggestion :)



