function display_graph(html_data){
    /*
     * data intro:
     * nodes.flag -> 1: main object(search result object), will use large circle  
     */
    
    var graph = {
            nodes : {
                "p1":{id: "p1", type: "publication", title: "paper1", flag: 0}, //key/id: type first letter + int auto increase
                "a1":{id: "a1", type: "author",name: "author1", flag: 0},
                "e1":{id: "e1", type: "editor",name: "editor1", flag: 0},
                "c1":{id: "c1", type: "price",name: "price1", flag: 0},
                "y1":{id: "y1", type: "year",name: "year1", flag: 0}        
                "p2":{id: "p1", type: "publication", title: "paper2", flag: 0}, //key/id: type first letter + int auto increase
                "a2":{id: "a1", type: "author",name: "author2", flag: 0},
                "e2":{id: "e1", type: "editor",name: "editor2", flag: 0},
                "c2":{id: "c1", type: "price",name: "price2", flag: 0},
                "y2":{id: "y1", type: "year",name: "year2", flag: 0}        
            },

            links : [ {
                id : 1,
                source : "p1",
                target : "y1",
                relationship : "PublishedIn"
            }, {
                id : 2,
                source : "p1",
                target : "e1",
                relationship : "EditBy"
            }, {
                id : 3,
                source : "p1",
                target : "a1",
                relationship : "AuthorBy"
            }, {
                id : 4,
                source : "p1",
                target : "c1",
                relationship : "cost"
            } ,{
                id : 7,
                source : "p2",
                target : "y1",
                relationship : "PublishedIn"
            }, {
                id : 5,
                source : "p2",
                target : "a1",
                relationship : "EditBy"
            }, {
                id : 6,
                source : "p2",
                target : "a2",
                relationship : "AuthorBy"
            }, {
                id : 8
                source : "p2",
                target : "c2",
                relationship : "cost"
            } ]
        };
        
        var nodes = graph.nodes;
        var rel = {};
        var links = graph.links;

        // change links's objects:
        for (var i = 0, l = links.length; i < l; i++) {
            var link = links[i];

            var sLinkSrc = link.source;
            var sLinkTgt = link.target;

            link.source = nodes[sLinkSrc]; // to node obj
            link.target = nodes[sLinkTgt]; // to node obj

        }

        console.log(nodes);
        console.log(links);

        var width = screen.width - 80, height = screen.height - 80;

        console.log("Width: " + width);
        console.log("Height: " + height);
        
        // draw
        var force = d3.layout.force()
                .nodes(d3.values(nodes)) //map{} -> array[]
                .links(links).size([ width, height ])
                .linkDistance(350)
                .charge(-800)
                .on("tick", tick)
                .start();
        
        var node_radius = {"small":20, "big":40};
        var markerWidth = 8;
        var markerHeight = 8;     

        var drag = force.drag().on("dragstart", dragstart);

        var svg = d3.select("#graph_display_area").append("svg").attr("width", width).attr("height",
                height);

        // build the arrow.
        // "refX", 40 -> adjust the arrow to fit the circle size
        
            //for small node
        var marker_small = svg.append("svg:defs").selectAll("marker").data(["end_small"]).enter().append(
                "svg:marker")
                .attr("id", String)
                .attr("viewBox", "0 -5 10 10")
                .attr("refX", node_radius["small"] + (markerWidth * 2)) //30
                .attr("refY", -Math.sqrt(node_radius["small"]) ) //-1
                .attr("markerWidth", markerWidth)
                .attr("markerHeight", markerHeight).attr("orient", "auto").append("svg:path").attr("d",
                "M0,-5L10,0L0,5");
        
            //for big node 
        var marker_big = svg.append("svg:defs").selectAll("marker").data(["end_big"]).enter().append(
        "svg:marker")
        .attr("id", String)
        .attr("viewBox", "0 -5 10 10")
        .attr("refX", node_radius["big"] + (markerWidth * 2)) //50
        .attr("refY", -Math.sqrt(node_radius["big"]) ) //-1
        .attr("markerWidth", markerWidth)
        .attr("markerHeight", markerHeight).attr("orient", "auto").append("svg:path").attr("d",
        "M0,-5L10,0L0,5");
        
        // add the links and the arrows
        var path = svg.append("svg:g").selectAll("path").data(force.links()).enter()
                .append("svg:path").attr("id", function(d) {
                    return d.id;
                }).attr("class", "link").attr("marker-end", function(d){
                    var tmp;
                    if (d.target.flag==1){
                        tmp = "big";
                    }
                    else{
                        tmp = "small";
                    }
                    var result = "url(#end_"+tmp+")";

                    return result;
                }); 

        // add text on the link (the relationship)
        var mytext = svg.append("svg:g").selectAll("text").data(force.links()).enter()
                .append("text").attr("dx", "150").attr("dy", "-8").append("textPath")
                .attr("xlink:href", function(d) {
                    return "#" + d.id;
                }).attr("style", "fill:magenta; font-weight:bold; font-size:12").text(
                        function(d) {
                            return d.relationship;
                        });

        // define the nodes
        var node = svg.selectAll(".node").data(force.nodes()).enter().append("g").attr(
                "class", "node").call(force.drag);

        // add the nodes using circle
        node.append("circle")
                .attr("r", function(d){
                    if (d.flag==1){
                        return node_radius["big"];
                    }
                    else{
                        return node_radius["small"];
                    }
                })
                .attr("style", getFillingColor)  //different object type different filling color
                .append("svg:title")
                .text(function(d) {
                    return "detail";
                }).transition();

        /*
         * //add the nodes using rectagle with round corner var rectWidth = 40; var
         * rectHeight = 20; node.append("rect").attr("class", "nodeRect") .attr("rx", 5)
         * .attr("ry", 5) .attr("width", 40) .attr("height", 20) .attr("fill", "grey")
         * .append( "svg:title").text(function(d) { return "Source: " + d.srccnt + " ~
         * Target: " + d.tgtcnt; }).transition();
         */


         //add the text outside the node shape 
         node.append("text")
         .attr("x",30)
         .attr("dy", ".35em")
         .text(function(d) { return ""; }); 
         
        // add the text inside
        node.append("text").attr("text-anchor", "middle")
        .attr("style", function(d) {return "font-weight:bold; fill:red"})
        .text(function(d) {
            return "ID: "+d.id ;
        })

        function tick() {
            // add the curvy lines
            path
                    .attr(
                            "d",
                            function(d) {
                                var dx = d.target.x - d.source.x, dy = d.target.y
                                        - d.source.y, dr = Math.sqrt(dx * dx + dy * dy);
                                return "M" + d.source.x + "," + d.source.y + "A" + dr
                                        + "," + dr + " 0 0,1 " + d.target.x + ","
                                        + d.target.y;
                            });

            node.attr("transform", function(d) {
                return "translate(" + d.x + "," + d.y + ")";
            });
        }

        function dragstart(d) {
            d3.select(this).classed("fixed", d.fixed = true);
        }

        function getFillingColor(d){
            var color;
            switch(d.type) {
            case "publication":
                color = "#BCF5A9";  //green
                break;
            case "author":
                color = "#F5F6CE";  //yellow
                break;
            case "venue":
                color = "#F5A9A9";  //red
                break;
            default:
                color = "#BCF5A9";  //green
            }
            //alert(color);
            return "fill:"+color;

        }
}