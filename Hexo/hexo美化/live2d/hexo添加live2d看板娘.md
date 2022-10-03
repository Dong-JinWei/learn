# hexo 添加live2d看板娘

## 获取live2d：

    $ npm install --save hexo-helper-live2d

下载对应的模型，使用`npm install live2d-widget-model-haru
`

详细可参考[https://blog.csdn.net/wang_123_zy/article/details/87181892]

## 打开站点目录下的_config.yml文件，添加如下代码：

```yaml
live2d:
	enable: true
	scriptFrom: local
	model: 
		use: live2d-widget-model-haruto #模型选择
	display: 
		position: right  #模型位置
		width: 150       #模型宽度
		height: 300      #模型高度
	mobile: 
		show: false      #是否在手机端显示
```

设置好之后就会有一个看板娘了