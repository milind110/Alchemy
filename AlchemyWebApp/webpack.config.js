config = {
   entry: './main.js',
	
   output: {
      path:'/Users/glarimy/Professional/Workspace/Glarimy-ReactJS/glarimy-reactjs-11/target',
      filename: 'index.js',
   },
	
   devServer: {
      inline: true,
      host: '0.0.0.0',
      port: 7070
   },
	
   module: {
      loaders: [
         {
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel-loader',            
            query: {
               presets: ['es2015', 'react']
            }
         },{
            test: /\.css?$/,
            loader: "style-loader!css-loader"
         }
      ]
   }
}

module.exports = config;
