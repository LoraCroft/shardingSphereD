shardingSphere 分库分表策略：inline, standard,complex,hint,none

inline:简单表达式策略，不支持 范围查询
参数:    
1、sharding-column 分片字段
2、algorithm-expression：分片表达式

standard: 标准策略 （支持范围查询）
参数:     
1、precise-algorithm-class-name :
2、ange-algorithm-class-name   

complex: 支持多分片键的复杂分片策略
参数:
1、sharding-columns     分片键
2、algorithm-class-name 分片策略

hint：强制路由 (分片键和sql无关)
参数：
1、algorithm-class-name 算法类